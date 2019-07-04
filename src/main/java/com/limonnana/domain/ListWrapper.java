package com.limonnana.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "list_wrapper")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ListWrapper {

    @Id
    private int id;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UnitOfCalendar> list;

    public List<UnitOfCalendar> getList() {
        return list;
    }

    public void setList(List<UnitOfCalendar> list) {
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
