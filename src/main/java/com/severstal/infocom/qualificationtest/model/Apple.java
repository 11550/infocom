package com.severstal.infocom.qualificationtest.model;

import com.severstal.infocom.qualificationtest.enums.FruitType;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "apple")
public class Apple extends Fruit {

    @Override
    public FruitType getType() {
        return FruitType.APPLE;
    }
}
