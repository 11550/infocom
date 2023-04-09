package com.severstal.infocom.qualificationtest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_line")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "goods_id", referencedColumnName = "id")
    private Goods goods;

    private Double weight;

    public OrderLine(Goods goods, Double weight) {
        this.goods = goods;
        this.weight = weight;
    }

    // <editor-fold defaultstate="collapsed" desc="equals, hashcode, toString">

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLine order = (OrderLine) o;
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
