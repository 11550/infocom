package com.severstal.infocom.qualificationtest.service;

import com.severstal.infocom.qualificationtest.model.Order;
import com.severstal.infocom.qualificationtest.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {
    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order get(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No entity found with id " + id));
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order update(Order order) {
        return create(order);
    }

    @Override
    public void delete(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<Long> ids) {
        orderRepository.deleteAllById(ids);
    }

}
