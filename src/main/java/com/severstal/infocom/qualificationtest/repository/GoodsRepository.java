package com.severstal.infocom.qualificationtest.repository;

import com.severstal.infocom.qualificationtest.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {
}
