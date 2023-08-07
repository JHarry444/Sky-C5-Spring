package com.qa.spring.hedgehog.services;


import com.qa.spring.hedgehog.domain.Garden;
import com.qa.spring.hedgehog.domain.Hedgehog;
import com.qa.spring.hedgehog.dtos.GardenDTO;
import com.qa.spring.hedgehog.dtos.HedgehogDTO;
import com.qa.spring.hedgehog.repos.GardenRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GardenService {

    private GardenRepo repo;

    public GardenService(GardenRepo repo) {
        this.repo = repo;
    }


    public Garden create(Garden garden) {
        return this.repo.save(garden);
    }


    public List<Garden> create(List<Garden> newGardens) {
        return this.repo.saveAll(newGardens);
    }


    public List<GardenDTO> getAll() {
        List<Garden> gardens = this.repo.findAll();

        List<GardenDTO> dtos = new ArrayList<>();
        for (Garden g : gardens) {
            GardenDTO dto = new GardenDTO();
            dto.setId(g.getId());
            dto.setType(g.getType());
            dto.setAddress(g.getAddress());

            List<HedgehogDTO> hogs = new ArrayList<>();
            for (Hedgehog h : g.getHedgehogs()) {
                HedgehogDTO hDto = new HedgehogDTO();
                hDto.setId(h.getId());
                hDto.setName(h.getName());
                hDto.setColour(h.getColour());
                hDto.setAge(h.getAge());
                hDto.setGardenId(g.getId());
                hogs.add(hDto);
            }
            dto.setHedgehogs(hogs);


            dtos.add(dto);
        }

        return dtos;
    }


    public Garden getById(int id) {
        Garden actualGarden = this.repo.findById(id).get();

        return actualGarden;
    }


    public Garden update(int id, String type, String address) {
        Garden toUpdate = this.getById(id);

        if (type != null) toUpdate.setType(type);
        if (address != null) toUpdate.setAddress(address);

        return this.repo.save(toUpdate);
    }


    public Garden remove(int id) {
        Garden toDelete = this.getById(id);
        this.repo.deleteById(id);
        return toDelete;
    }

}
