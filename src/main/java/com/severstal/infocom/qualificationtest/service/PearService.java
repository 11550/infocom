package com.severstal.infocom.qualificationtest.service;

import com.severstal.infocom.qualificationtest.model.Pear;
import com.severstal.infocom.qualificationtest.repository.PearRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PearService implements IFruitService<Pear> {
    private final PearRepository pearRepository;

    @Override
    public Pear create(Pear Pear) {
        return pearRepository.save(Pear);
    }

    @Override
    @Transactional
    public List<Pear> create(List<Pear> pears) {
        return pearRepository.saveAll(pears);
    }

    @Override
    public Pear get(Long id) {
        return pearRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No entity found with id " + id));
    }

    @Override
    public List<Pear> getAll() {
        return pearRepository.findAll();
    }

    @Override
    public Pear update(Pear Pear) {
        return create(Pear);
    }

    @Override
    public void delete(Pear Pear) {
        pearRepository.delete(Pear);
    }

    @Override
    public void delete(Long id) {
        pearRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<Long> ids) {
        pearRepository.deleteAllById(ids);
    }
}
