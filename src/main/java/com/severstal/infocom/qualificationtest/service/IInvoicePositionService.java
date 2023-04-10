package com.severstal.infocom.qualificationtest.service;

import com.severstal.infocom.qualificationtest.model.InvoicePosition;

import java.util.Date;
import java.util.List;

public interface IInvoicePositionService extends ICrudService<InvoicePosition> {
    List<InvoicePosition> getAllByDateBetween(Date from, Date to);
}
