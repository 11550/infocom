package com.severstal.infocom.qualificationtest.repository;

import com.severstal.infocom.qualificationtest.model.Pear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PearRepository extends JpaRepository<Pear, Long> {
}
