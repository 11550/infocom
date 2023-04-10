package com.severstal.infocom.qualificationtest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "goods")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private Period period;

    @ManyToOne
    private Fruit fruit;

    private Double price;

    //<editor-fold desc="constructors" defaultstate="collapsed">
    public Goods(Supplier supplier, Period period, Fruit fruit, Double price) {
        this.supplier = supplier;
        this.period = period;
        this.fruit = fruit;
        this.price = price;
    }
    //</editor-fold>

    //<editor-fold desc="equals, hashcode, toString" defaultstate="collapsed">
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods priceList = (Goods) o;
        return Objects.equals(id, priceList.id) && Objects.equals(supplier, priceList.supplier) && Objects.equals(period, priceList.period) && Objects.equals(fruit, priceList.fruit) && Objects.equals(price, priceList.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, supplier, period, fruit, price);
    }

    @Override
    public String toString() {
        return "PriceList{" +
                "id=" + id +
                ", supplier=" + supplier +
                ", period=" + period +
                ", fruit=" + fruit +
                ", price=" + price +
                '}';
    }
    //</editor-fold>
}
