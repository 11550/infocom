package com.severstal.infocom.qualificationtest.repository;

import com.severstal.infocom.qualificationtest.model.Apple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppleRepository extends JpaRepository<Apple, Long> {
}
