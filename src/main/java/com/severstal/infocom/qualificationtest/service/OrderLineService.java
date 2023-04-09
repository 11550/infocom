package com.severstal.infocom.qualificationtest.service;

import com.severstal.infocom.qualificationtest.model.OrderLine;
import com.severstal.infocom.qualificationtest.repository.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderLineService implements IOrderLineService {
    private final OrderLineRepository orderLineRepository;

    @Override
    @Transactional
    public OrderLine create(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

    @Override
    public OrderLine get(Long id) {
        return orderLineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No entity found with id " + id));
    }

    @Override
    public List<OrderLine> getAll() {
        return orderLineRepository.findAll();
    }

    @Override
    public OrderLine update(OrderLine orderLine) {
        return create(orderLine);
    }

    @Override
    public void delete(OrderLine orderLine) {
        orderLineRepository.delete(orderLine);
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
