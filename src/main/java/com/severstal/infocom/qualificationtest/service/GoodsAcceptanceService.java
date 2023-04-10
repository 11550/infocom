package com.severstal.infocom.qualificationtest.service;

import com.severstal.infocom.qualificationtest.model.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class GoodsAcceptanceService implements IGoodsAcceptanceService {
    private final IInvoiceService invoiceService;

    @Override
    public Invoice accept(Invoice invoice) {
        invoice.setAcceptDate(new Date());
        return invoiceService.update(invoice);
    }
}
