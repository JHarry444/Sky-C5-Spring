package com.qa.spring.hedgehog.services;

import com.qa.spring.hedgehog.domain.Hedgehog;
import com.qa.spring.hedgehog.dtos.HedgehogDTO;

import java.util.List;


public interface HedgehogService {

    HedgehogDTO create(HedgehogDTO hedgehog);

    List<Hedgehog> create(List<Hedgehog> newHedgehogs);


    List<Hedgehog> getAll();


    Hedgehog getById(int id);


    Hedgehog update(int id, String name, String colour, Integer age);

    Hedgehog remove(int id);

    List<Hedgehog> findByName(String name);

    Integer findAgeByName(String name);
}
