package com.severstal.infocom.qualificationtest.service;

import com.severstal.infocom.qualificationtest.model.Apple;
import com.severstal.infocom.qualificationtest.model.Pear;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final IPeriodService periodService;
    private final IFruitService<Apple> appleService;
    private final IFruitService<Pear> pearService;
    private final ISupplierService supplierService;
    private final IGoodsService goodsService;
    private final IInvoicePositionService invoicePositionService;
    private final IInvoiceService invoiceService;

    //Имеется 3 поставщика, каждый из поставщиков может поставлять 2 вида груш и 2 вида яблок.
    // Поставщики заранее сообщают свои цены на виды продукции на определенный период поставок.

    //б) создать отчет. За выбранный период показать поступление видов продукции по поставщикам
    // с итогами по весу и стоимости.


}
