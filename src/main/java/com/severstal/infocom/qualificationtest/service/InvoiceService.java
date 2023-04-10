package com.severstal.infocom.qualificationtest.service;

import com.severstal.infocom.qualificationtest.model.Order;
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
    public Order create(Order order) {
        return invoiceRepository.save(order);
    }

    @Override
    public List<Order> create(List<Order> orders) {
        return invoiceRepository.saveAll(orders);
    }

    @Override
    public Order get(Long id) {
        return invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No entity found with id " + id));
    }

    @Override
    public List<Order> getAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Order update(Order order) {
        return create(order);
    }

    @Override
    public void delete(Order order) {
        invoiceRepository.delete(order);
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
