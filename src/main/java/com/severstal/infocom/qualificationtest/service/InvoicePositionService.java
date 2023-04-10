package com.severstal.infocom.qualificationtest.service;

import com.severstal.infocom.qualificationtest.model.InvoicePosition;
import com.severstal.infocom.qualificationtest.repository.InvoicePositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoicePositionService implements IInvoicePositionService {
    private final InvoicePositionRepository invoicePositionRepository;

    @Override
    @Transactional
    public InvoicePosition create(InvoicePosition invoicePosition) {
        return invoicePositionRepository.save(invoicePosition);
    }

    @Override
    public List<InvoicePosition> create(List<InvoicePosition> invoicePositions) {
        return invoicePositionRepository.saveAll(invoicePositions);
    }

    @Override
    public InvoicePosition get(Long id) {
        return invoicePositionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No entity found with id " + id));
    }

    @Override
    public List<InvoicePosition> getAll() {
        return invoicePositionRepository.findAll();
    }

    @Override
    public List<InvoicePosition> getAllByDateBetween(Date from, Date to) {
        return invoicePositionRepository.findAllByDateBetween(from, to);
    }

    @Override
    public InvoicePosition update(InvoicePosition invoicePosition) {
        return create(invoicePosition);
    }

    @Override
    public void delete(InvoicePosition invoicePosition) {
        invoicePositionRepository.delete(invoicePosition);
    }

    @Override
    public void delete(Long id) {
        invoicePositionRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<Long> ids) {
        invoicePositionRepository.deleteAllById(ids);
    }

}
