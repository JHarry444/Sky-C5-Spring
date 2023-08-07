package com.qa.spring.hedgehog.services;

import com.qa.spring.hedgehog.domain.Garden;
import com.qa.spring.hedgehog.domain.Hedgehog;
import com.qa.spring.hedgehog.dtos.HedgehogDTO;
import com.qa.spring.hedgehog.exceptions.HedgehogNotFoundException;
import com.qa.spring.hedgehog.repos.HedgehogRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Primary
@Service
public class HedgehogServiceDB implements HedgehogService {

    private HedgehogRepo repo;

    public HedgehogServiceDB(HedgehogRepo repo) {
        this.repo = repo;
    }

    @Override
    public HedgehogDTO create(HedgehogDTO hedgehog) {
        Hedgehog toCreate = new Hedgehog();
        toCreate.setAge(hedgehog.getAge());
        toCreate.setName(hedgehog.getName());
        toCreate.setColour(hedgehog.getColour());
        toCreate.setGarden(new Garden(hedgehog.getGardenId()));


        Hedgehog created = this.repo.save(toCreate);

        return new HedgehogDTO(created);
    }

    @Override
    public List<HedgehogDTO> create(List<HedgehogDTO> newHedgehogs) {
        List<Hedgehog> newHogs = newHedgehogs.stream().map(
                dto -> new Hedgehog(
                        dto.getId(),
                        dto.getName(),
                        dto.getColour(),
                        dto.getAge(),
                        new Garden(dto.getGardenId()))
        ).collect(Collectors.toList());
        return this.repo.saveAll(newHogs).stream().map(HedgehogDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<HedgehogDTO> getAll() {
        return this.repo.findAll().stream().map(HedgehogDTO::new).collect(Collectors.toList());
    }

    @Override
    public HedgehogDTO getById(int id) {
        Hedgehog actualHedgehog = this.repo.findById(id).orElseThrow(() -> new HedgehogNotFoundException());

        return new HedgehogDTO(actualHedgehog);
    }

    @Override
    public HedgehogDTO update(int id, String name, String colour, Integer age) {
        Hedgehog toUpdate = this.repo.findById(id).orElseThrow(() -> new HedgehogNotFoundException());

        if (name != null) toUpdate.setName(name);
        if (colour != null) toUpdate.setColour(colour);
        if (age != null) toUpdate.setAge(age);

        return new HedgehogDTO(this.repo.save(toUpdate));
    }

    @Override
    public HedgehogDTO remove(int id) {
        HedgehogDTO toDelete = this.getById(id);
        this.repo.deleteById(id);
        return toDelete;
    }

    @Override
    public List<HedgehogDTO> findByName(String name) {
        return this.repo.findByNameContainsIgnoreCase(name).stream().map(HedgehogDTO::new).collect(Collectors.toList());
    }

    @Override
    public Integer findAgeByName(String name) {
        return this.repo.findAgeByName(name);
    }
}
