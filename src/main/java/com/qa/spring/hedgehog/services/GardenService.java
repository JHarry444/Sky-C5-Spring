package com.qa.spring.hedgehog.services;


import com.qa.spring.hedgehog.domain.Garden;
import com.qa.spring.hedgehog.repos.GardenRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GardenService  {

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

    
    public List<Garden> getAll() {
        return this.repo.findAll();
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
