package com.severstal.infocom.qualificationtest.repository;

import com.severstal.infocom.qualificationtest.model.InvoicePosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface InvoicePositionRepository extends JpaRepository<InvoicePosition, Long> {
    @Query(value = "SELECT ip.* FROM invoice_position ip " +
            "JOIN goods g ON g.id = ip.goods_id " +
            "JOIN period p on p.id = g.period_id " +
            "WHERE ",
    nativeQuery = true)
    List<InvoicePosition> findAllByDateBetween(Date from, Date to);
}
