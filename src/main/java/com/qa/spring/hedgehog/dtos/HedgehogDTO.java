package com.qa.spring.hedgehog.dtos;

import com.qa.spring.hedgehog.domain.Hedgehog;

public class HedgehogDTO {

    private Integer id;
    private String name;
    private String colour;
    private Integer age;

    private Integer gardenId;

    public HedgehogDTO(Hedgehog h) {
        this.id = h.getId();
        this.name = h.getName();
        this.age = h.getAge();
        this.colour = h.getColour();
        this.gardenId = h.getGarden().getId();
    }

    public HedgehogDTO() {
    }

    public Integer getGardenId() {
        return gardenId;
    }

    public void setGardenId(Integer gardenId) {
        this.gardenId = gardenId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
