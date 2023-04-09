package com.severstal.infocom.qualificationtest.model;


import com.severstal.infocom.qualificationtest.enums.FruitType;

import javax.persistence.*;

@Entity
@Table(name = "pear")
public class Pear extends Fruit {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;


    @Override
    public FruitType getType() {
        return FruitType.PEAR;
    }
}
