package com.severstal.infocom.qualificationtest.service;

import com.severstal.infocom.qualificationtest.model.Apple;
import com.severstal.infocom.qualificationtest.repository.AppleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppleService implements IFruitService<Apple> {
    private final AppleRepository appleRepository;

    @Override
    public Apple create(Apple apple) {
        return appleRepository.save(apple);
    }

    @Override
    public Apple get(Long id) {
        return appleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No entity found with id " + id));
    }

    @Override
    public List<Apple> getAll() {
        return appleRepository.findAll();
    }

    @Override
    public Apple update(Apple apple) {
        return create(apple);
    }

    @Override
    public void delete(Apple apple) {
        appleRepository.delete(apple);
    }

    @Override
    public void delete(Long id) {
        appleRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<Long> ids) {
        appleRepository.deleteAllById(ids);
    }
}
