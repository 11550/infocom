package com.severstal.infocom.qualificationtest.repository;

import com.severstal.infocom.qualificationtest.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
