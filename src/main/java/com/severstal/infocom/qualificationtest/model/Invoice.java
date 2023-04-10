package com.severstal.infocom.qualificationtest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "invoice")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // по логике - в одной накладной должны быть позиции от одного поставщика.. Как это реализовать красиво
    @OneToMany
    private Set<InvoicePosition> invoicePositions;

    // дата-время создания заказа должны влиять на стоимость конкретных товаров в конкретном периоде
    @CreationTimestamp
    private Date orderDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Supplier supplier;

    //<editor-fold desc="constructors" defaultstate="collapsed">
    public Invoice(Set<InvoicePosition> invoicePositions) {
        this.invoicePositions = invoicePositions;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="equals, hashcode, toString">

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(id, invoice.id) && Objects.equals(invoicePositions, invoice.invoicePositions);
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
