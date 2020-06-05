package de.jonashackt.springbootvuejs.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="lates")
public class Late {

    // PrimaryKey
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private Long minutes;
    private LocalDate date;

    public Late(String name, Long minutes, LocalDate date) {
        this.name = name;
        this.minutes = minutes;
        this.date = date;
    }

    public Late() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMinutes() {
        return minutes;
    }

    public void setMinutes(Long minutes) {
        this.minutes = minutes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
