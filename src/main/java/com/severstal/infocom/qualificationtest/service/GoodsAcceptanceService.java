package com.severstal.infocom.qualificationtest.service;

import com.severstal.infocom.qualificationtest.model.Apple;
import com.severstal.infocom.qualificationtest.model.Pear;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoodsAcceptanceService {
    private final PeriodService periodService;
    private final IFruitService<Apple> appleService;
    private final IFruitService<Pear> pearService;
    private final SupplierService supplierService;
    private final GoodsService goodsService;
    private final InvoicePositionService orderLineService;
    private final InvoiceService orderService;

    //Имеется 3 поставщика, каждый из поставщиков может поставлять 2 вида груш и 2 вида яблок.
    // Поставщики заранее сообщают свои цены на виды продукции на определенный период поставок.

    //а) создать интерфейс приемки поставок от поставщиков.
    // В одной поставке от поставщика может быть несколько видов продукции.
}
