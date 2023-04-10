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
@Table(name = "apple")
@NoArgsConstructor
@Getter
@Setter
public class Apple extends Fruit {

    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    //<editor-fold desc="static" defaultstate="collapsed">
    public static Apple create() {
        return new Apple();
    }

    public static Apple create(String name) {
        return new Apple(name);
    }

    public static List<Apple> create(Integer count) {
        return create("a", count);
    }

    public static List<Apple> create(String prefix, Integer count) {
        return IntStream.rangeClosed(1, count)
                .mapToObj(i -> Apple.create(prefix + i))
                .collect(Collectors.toList());
    }
    //</editor-fold>

    //<editor-fold desc="constructors" defaultstate="collapsed">
    public Apple(String name) {
        this.name = name;
    }
    //</editor-fold>

    //<editor-fold desc="equals, hashcode, toString" defaultstate="collapsed">
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apple apple = (Apple) o;
        return Objects.equals(id, apple.id) && Objects.equals(name, apple.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    //</editor-fold>
}
