package com.severstal.infocom.qualificationtest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "invoice_position")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InvoicePosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Goods goods;

    private Double weight;

    //<editor-fold desc="constructors" defaultstate="collapsed">
    public InvoicePosition(Goods goods, Double weight) {
        this.goods = goods;
        this.weight = weight;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="equals, hashcode, toString">

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoicePosition order = (InvoicePosition) o;
        return Objects.equals(id, order.id) && Objects.equals(goods, order.goods) && Objects.equals(weight, order.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, goods, weight);
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", goods=" + goods +
                ", weight=" + weight +
                '}';
    }

    // </editor-fold>
}
