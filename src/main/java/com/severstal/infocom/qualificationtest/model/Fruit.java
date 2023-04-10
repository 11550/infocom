package com.severstal.infocom.qualificationtest.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String name;

    public static Fruit create() {
        return new Fruit();
    }

    public static Fruit create(String name) {
        return new Fruit(name);
    }

    public static List<? extends Fruit> create(Integer count) {
        return create("f", count);
    }

    public static List<? extends Fruit> create(String prefix, Integer count) {
        return IntStream.rangeClosed(1, count)
                .mapToObj(i -> Fruit.create(prefix + i))
                .collect(Collectors.toList());
    }

    //<editor-fold desc="constructors" defaultstate="collapsed">
    public Fruit(String name) {
        this.name = name;
    }
    //</editor-fold>

    //<editor-fold desc="equals, hashcode, toString" defaultstate="collapsed">
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return Objects.equals(id, fruit.id) && Objects.equals(name, fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    //</editor-fold>
}
