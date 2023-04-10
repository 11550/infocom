package com.severstal.infocom.qualificationtest.repository;

import com.severstal.infocom.qualificationtest.model.InvoicePosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface InvoicePositionRepository extends JpaRepository<InvoicePosition, Long> {
}
