package com.severstal.infocom.qualificationtest.service;

import com.severstal.infocom.qualificationtest.model.Invoice;
import com.severstal.infocom.qualificationtest.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService implements IInvoiceService {
    private final InvoiceRepository invoiceRepository;

    @Override
    @Transactional
    public Invoice create(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public List<Invoice> create(List<Invoice> invoices) {
        return invoiceRepository.saveAll(invoices);
    }

    @Override
    public Invoice get(Long id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No entity found with id " + id));
    }

    @Override
    public List<Invoice> getAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice update(Invoice invoice) {
        return create(invoice);
    }

    @Override
    public void delete(Invoice invoice) {
        invoiceRepository.delete(invoice);
    }

    @Override
    public void delete(Long id) {
        invoiceRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<Long> ids) {
        invoiceRepository.deleteAllById(ids);
    }

}
