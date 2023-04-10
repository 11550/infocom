package com.severstal.infocom.qualificationtest.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Entity
@Table(name = "pear")
@NoArgsConstructor
@Getter
@Setter
public class Pear extends Fruit {

    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    //<editor-fold desc="static" defaultstate="collapsed">

    public static Pear create() {
        return new Pear();
    }

    public static Pear create(String name) {
        return new Pear(name);
    }

    public static List<Pear> create(Integer count) {
        return create("p", count);
    }

    public static List<Pear> create(String prefix, Integer count) {
        return IntStream.rangeClosed(1, count)
                .mapToObj(i -> Pear.create(prefix + i))
                .collect(Collectors.toList());
    }
    //</editor-fold>

    //<editor-fold desc="constructors" defaultstate="collapsed">
    public Pear(String name) {
        this.name = name;
    }
    //</editor-fold>

    //<editor-fold desc="equals, hashcode, toString" defaultstate="collapsed">
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pear pear = (Pear) o;
        return Objects.equals(id, pear.id) && Objects.equals(name, pear.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Pear{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    //</editor-fold>
}
