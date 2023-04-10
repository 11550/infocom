package com.severstal.infocom.qualificationtest.service;

import com.severstal.infocom.qualificationtest.model.Period;
import com.severstal.infocom.qualificationtest.repository.PeriodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PeriodService implements IPeriodService {
    private final PeriodRepository periodRepository;

    @Override
    public Period create(Period period) {
        if (isOverlapping(period)) {
            throw new RuntimeException("Period intersects");
        }
        return periodRepository.save(period);
    }

    @Override
    public List<Period> create(List<Period> periods) {
        return periodRepository.saveAll(periods);
    }

    public Period get(Long id) {
        return periodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No entity found with id " + id));
    }

    public Optional<Period> getCurrent() {
        Date date = new Date();
        return getPeriodByDate(date);
    }

    public Optional<Period> getPeriodByDate(Date date) {
        return periodRepository.findByDate(date);
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

    private boolean isIntersects(Period period, Period another) {
        isCorrect(period);
        isCorrect(another);
        return period.getStart().after(another.getStart()) && period.getStart().before(another.getEnd())
                || period.getEnd().after(another.getStart()) && period.getEnd().before(another.getEnd());
    }

    private boolean isOverlapping(Period period) {
        isCorrect(period);
        return periodRepository.checkOverlapping(period.getStart(), period.getEnd()).intValue() == 1;
    }

    private void isCorrect(Period period) {
        if (equalsOrAfter(period.getStart(), period.getEnd())) {
            throw new RuntimeException(String.format("Incorrect dates in the period: %s", period));
        }
    }

    private boolean equalsOrAfter(Date date, Date dateAnother) {
        return date.getTime() == dateAnother.getTime()
                || date.after(dateAnother);
    }
}
