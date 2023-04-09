package com.severstal.infocom.qualificationtest.repository;

import com.severstal.infocom.qualificationtest.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
