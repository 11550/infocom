package com.severstal.infocom.qualificationtest.service;

import com.severstal.infocom.qualificationtest.model.InvoicePosition;
import com.severstal.infocom.qualificationtest.repository.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoicePositionService implements IInvoicePositionService {
    private final OrderLineRepository orderLineRepository;

    @Override
    @Transactional
    public InvoicePosition create(InvoicePosition invoicePosition) {
        return orderLineRepository.save(invoicePosition);
    }

    @Override
    public List<InvoicePosition> create(List<InvoicePosition> invoicePositions) {
        return orderLineRepository.saveAll(invoicePositions);
    }

    @Override
    public InvoicePosition get(Long id) {
        return orderLineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No entity found with id " + id));
    }

    @Override
    public List<InvoicePosition> getAll() {
        return orderLineRepository.findAll();
    }

    @Override
    public InvoicePosition update(InvoicePosition invoicePosition) {
        return create(invoicePosition);
    }

    @Override
    public void delete(InvoicePosition invoicePosition) {
        orderLineRepository.delete(invoicePosition);
    }

    @Override
    public void delete(Long id) {
        orderLineRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<Long> ids) {
        orderLineRepository.deleteAllById(ids);
    }

}
