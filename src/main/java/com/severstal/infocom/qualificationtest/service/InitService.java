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
    private final IOrderLineService orderLineService;
    private final IOrderService orderService;
    private final IPeriodService periodService;
    private final ISupplierService supplierService;

    @PostConstruct
    @Transactional
    public void init() {
        Period period = periodService.create(
                new Period(new Date(), new Date(new Date().getTime() + 1000 * 3600 * 24 * 7 * 4L))
        );
        init(period);
        init(period);
        init(period);
    }

    @Transactional
    public void init(Period period) {

        Supplier supplier = supplierService.create(Supplier.create());
        Apple apple = appleService.create(new Apple());
        Apple apple1 = appleService.create(new Apple());

        Pear pear = pearService.create(new Pear());
        Pear pear1 = pearService.create(new Pear());

        supplier.setApples(new ArrayList<Apple>() {{
            add(apple);
            add(apple1);
        }});
        supplier.setPears(new ArrayList<Pear>() {{
            add(pear);
            add(pear1);
        }});

        Random random = new Random();
        Set<OrderLine> orderLines = Stream.of(supplier.getApples(), supplier.getPears())
                .flatMap(Collection::stream)
                .map(fruit -> {
                    Goods goods = goodsService.create(new Goods(supplier, period, fruit, random.nextDouble()));
                    return orderLineService.create(new OrderLine(goods, random.nextDouble()));
                })
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Order order = orderService.create(new Order(orderLines));
        System.out.println(order);
    }
}
