package com.severstal.infocom.qualificationtest.service;

import com.severstal.infocom.qualificationtest.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class InitService {
    private final IFruitService<Apple> appleService;
    private final IFruitService<Pear> pearService;
    private final IGoodsService goodsService;
    private final IInvoicePositionService orderLineService;
    private final IInvoiceService orderService;
    private final IPeriodService periodService;
    private final ISupplierService supplierService;

    @PostConstruct
    @Transactional
    public void init() {
        Period period = periodService.create(
                new Period(new Date(), new Date(new Date().getTime() + 1000 * 3600 * 24 * 7 * 4L))
        );
        init(period, "first");
        init(period, "second");
        init(period, "third");
    }

    @Transactional
    public void init(Period period, String prefix) {
        List<Apple> apples = appleService.create(Apple.create(prefix, 2));
        List<Pear> pears = pearService.create(Pear.create(prefix, 2));
        Supplier supplier = supplierService.create(new Supplier(apples, pears));

        Random random = new Random();
        Set<InvoicePosition> invoicePositions = Stream.of(supplier.getApples(), supplier.getPears())
                .flatMap(Collection::stream)
                .map(fruit -> {
                    Goods goods = goodsService.create(new Goods(supplier, period, fruit, random.nextDouble() * 100));
                    return orderLineService.create(new InvoicePosition(goods, random.nextDouble() * 10));
                })
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Order order = orderService.create(new Order(invoicePositions));
        System.out.println(order);
    }
}
