package com.severstal.infocom.qualificationtest.service;

import com.severstal.infocom.qualificationtest.model.Period;
import com.severstal.infocom.qualificationtest.repository.PeriodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PeriodService implements IPeriodService {
    private final PeriodRepository periodRepository;

    @Override
    public Period create(Period period) {
        if (isIntersects(getCurrent(), period)) {
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

    public Period getCurrent() {
        Date date = new Date();
        return getPeriodByDate(date);
    }

    public Period getPeriodByDate(Date date) {
        return periodRepository.findByDate(date)
                .orElseThrow(() -> new RuntimeException("No entity found! date " + date));
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
