package com.qa.spring.hedgehog.dtos;

import com.qa.spring.hedgehog.domain.Hedgehog;

import java.util.List;

public class GardenDTO {

    private int id;
    private String type;
    private String address;
    private List<HedgehogDTO> hedgehogs;

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

    public List<HedgehogDTO> getHedgehogs() {
        return hedgehogs;
    }

    public void setHedgehogs(List<HedgehogDTO> hedgehogs) {
        this.hedgehogs = hedgehogs;
    }
}
