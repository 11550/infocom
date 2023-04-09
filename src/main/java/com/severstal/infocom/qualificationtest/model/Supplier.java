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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "apple_id")
    private List<Apple> apples;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pear_id")
    private List<Pear> pears;

    public static Supplier create() {
        return new Supplier();
    }

    public static List<Supplier> create(Integer count) {
        return IntStream.rangeClosed(1, count)
                .mapToObj(i -> Supplier.create())
                .collect(Collectors.toList());
    }

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
