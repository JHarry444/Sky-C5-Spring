package com.qa.spring.hedgehog.rest;


import com.qa.spring.hedgehog.domain.Garden;
import com.qa.spring.hedgehog.dtos.GardenDTO;
import com.qa.spring.hedgehog.services.GardenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/garden")
public class GardenController {

    private GardenService service;

    public GardenController(GardenService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World";
    }


    @PostMapping("/create")
    public ResponseEntity<Garden> create(@RequestBody Garden garden) {
        return new ResponseEntity<>(this.service.create(garden), HttpStatus.CREATED);
    }

    @PostMapping("/createMultiple")
    public ResponseEntity<List<Garden>> create(@RequestBody List<Garden> newGardens) {
        System.out.println("RECEIVED: " + newGardens);
        if (this.service.create(newGardens) != null) {
            return new ResponseEntity<>(newGardens, HttpStatus.CREATED);
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }


    @GetMapping("/getAll")
    public List<GardenDTO> getAll() {
        return this.service.getAll();
    }

    @GetMapping("/get/{id}")
    public Garden getById(@PathVariable int id) {
        return this.service.getById(id);
    }

    // @RequestParam works like @PathParam but it allows you to make certain parameters mandatory
    @PatchMapping("/update/{id}")
    public Garden update(@PathVariable int id, @RequestParam(value = "type", required = false) String type, @RequestParam(value = "address", required = false) String address) {
        return this.service.update(id, type, address);

    }

    @DeleteMapping("/remove/{id}")
    public Garden remove(@PathVariable int id) {
        return this.service.remove(id);
    }

}
