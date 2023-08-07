package com.qa.spring.hedgehog.services;

import com.qa.spring.hedgehog.domain.Hedgehog;
import com.qa.spring.hedgehog.dtos.HedgehogDTO;

import java.util.List;


public interface HedgehogService {

    HedgehogDTO create(HedgehogDTO hedgehog);

    List<HedgehogDTO> create(List<HedgehogDTO> newHedgehogs);


    List<HedgehogDTO> getAll();


    HedgehogDTO getById(int id);


    HedgehogDTO update(int id, String name, String colour, Integer age);

    HedgehogDTO remove(int id);

    List<HedgehogDTO> findByName(String name);

    Integer findAgeByName(String name);
}
