package com.severstal.infocom.qualificationtest.model;


import com.severstal.infocom.qualificationtest.enums.FruitType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    public FruitType getType() {
        return FruitType.ABSTRACT;
    }
}
