package com.severstal.infocom.qualificationtest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToMany(mappedBy = "supplier",
//            orphanRemoval = true,
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
    @OneToMany(fetch = FetchType.LAZY)
    private List<Apple> apples;

//    @OneToMany(mappedBy = "supplier",
//            orphanRemoval = true,
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
    @OneToMany(fetch = FetchType.LAZY)
    private List<Pear> pears;

//    public void addApple(Apple apple) {
//        apples.add(apple);
//        apple.setSupplier(this);
//    }
//
//    public void removeApple(Apple apple) {
//        apples.remove(apple);
//        apple.setSupplier(null);
//    }
//
//    public void addPear(Pear pear) {
//        pears.add(pear);
//        pear.setSupplier(this);
//    }
//
//    public void removePear(Pear pear) {
//        pears.remove(pear);
//        pear.setSupplier(null);
//    }

    //<editor-fold desc="static" defaultstate="collapsed">
    public static Supplier create() {
        return new Supplier();
    }

    public static List<Supplier> create(Integer count) {
        return IntStream.rangeClosed(1, count)
                .mapToObj(i -> Supplier.create())
                .collect(Collectors.toList());
    }
    //</editor-fold>

    //<editor-fold desc="constructors" defaultstate="collapsed">

    public Supplier(List<Apple> apples, List<Pear> pears) {
        this.apples = apples;
        this.pears = pears;
    }

    //</editor-fold>

    //<editor-fold desc="equals, hashcode, toString" defaultstate="collapsed">
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(id, supplier.id);
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                '}';
    }

    //</editor-fold>
}
