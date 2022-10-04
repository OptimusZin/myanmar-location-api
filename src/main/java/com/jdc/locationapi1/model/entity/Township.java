package com.jdc.locationapi1.model.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Township implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String name;

    @ManyToOne
    private State state;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Township township = (Township) o;
        return id == township.id && Objects.equals(name, township.name) && Objects.equals(state, township.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, state);
    }
}
