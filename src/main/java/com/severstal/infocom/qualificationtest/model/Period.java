package com.severstal.infocom.qualificationtest.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "period")
@NoArgsConstructor
@AllArgsConstructor
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;

    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date end;

    public Period(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    //<editor-fold desc="equals, hashcode, toString" defaultstate="collapsed">

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Period period = (Period) o;
        return Objects.equals(id, period.id) && Objects.equals(start, period.start) && Objects.equals(end, period.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, start, end);
    }

    @Override
    public String toString() {
        return "Period{" +
                "id=" + id +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    //</editor-fold>

}
