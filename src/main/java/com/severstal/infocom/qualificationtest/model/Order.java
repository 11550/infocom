package com.severstal.infocom.qualificationtest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private Set<InvoicePosition> invoicePositions;

    //<editor-fold desc="constructors" defaultstate="collapsed">
    public Order(Set<InvoicePosition> invoicePositions) {
        this.invoicePositions = invoicePositions;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="equals, hashcode, toString">

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(invoicePositions, order.invoicePositions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, invoicePositions);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderLines=" + invoicePositions +
                '}';
    }

// </editor-fold>
}
