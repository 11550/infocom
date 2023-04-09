package com.severstal.infocom.qualificationtest.repository;

import com.severstal.infocom.qualificationtest.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
}
