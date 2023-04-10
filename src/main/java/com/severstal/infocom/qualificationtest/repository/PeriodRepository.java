package com.severstal.infocom.qualificationtest.repository;

import com.severstal.infocom.qualificationtest.model.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface PeriodRepository extends JpaRepository<Period, Long> {
    @Query(value = "SELECT p.* FROM period p " +
            "WHERE :date between p.start_date and p.end_date ",
    nativeQuery = true)
    Optional<Period> findByDate(@Param("date") Date date);
}
