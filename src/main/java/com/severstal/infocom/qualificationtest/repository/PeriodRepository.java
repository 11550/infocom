package com.severstal.infocom.qualificationtest.repository;

import com.severstal.infocom.qualificationtest.model.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepository extends JpaRepository<Period, Long> {
}
