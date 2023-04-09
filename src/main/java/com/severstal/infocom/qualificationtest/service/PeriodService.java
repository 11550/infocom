package com.severstal.infocom.qualificationtest.service;

import com.severstal.infocom.qualificationtest.model.Period;
import com.severstal.infocom.qualificationtest.repository.PeriodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PeriodService implements IPeriodService {
    private final PeriodRepository periodRepository;

    @Override
    public Period create(Period period) {
        return periodRepository.save(period);
    }

    public Period get(Long id) {
        return periodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No entity found with id " + id));
    }

    @Override
    public List<Period> getAll() {
        return periodRepository.findAll();
    }

    @Override
    public Period update(Period period) {
        return create(period);
    }

    @Override
    public void delete(Period period) {
        periodRepository.delete(period);
    }

    @Override
    public void delete(Long id) {
        periodRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<Long> ids) {
        periodRepository.deleteAllById(ids);
    }
}
