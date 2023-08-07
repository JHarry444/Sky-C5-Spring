package com.qa.spring.hedgehog.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Garden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;

    private String address;

    @OneToMany(mappedBy = "garden") // name of FK
    private List<Hedgehog> hedgehogs;

    public Garden(int id, String type, String address) {
        this.id = id;
        this.type = type;
        this.address = address;
    }


    public Garden(int id) {
        this.id = id;
    }

    public Garden() {
    }

    public List<Hedgehog> getHedgehogs() {
        return hedgehogs;
    }

    public void setHedgehogs(List<Hedgehog> hedgehogs) {
        this.hedgehogs = hedgehogs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
