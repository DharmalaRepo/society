package com.tech.society.structure.controllers;

import com.tech.society.structure.models.SocietyFlat;
import com.tech.society.structure.models.SocietyParking;
import com.tech.society.structure.services.SocietyFlatService;
import com.tech.society.structure.services.SocietyParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parking")
public class SocietyParkingController {
    @Autowired
    SocietyParkingService service;

    @PostMapping public SocietyParking create(@RequestBody SocietyParking p) { return service.create(p); }
    @GetMapping public List<SocietyParking> getAll() { return service.getAll(); }
    @GetMapping("/society/{id}") public List<SocietyParking> getBySociety(@PathVariable Integer id) { return service.getBySocietyId(id); }
    @PutMapping("/{id}") public SocietyParking update(@PathVariable String id, @RequestBody SocietyParking p) { return service.update(id, p); }
    @DeleteMapping("/{id}") public void delete(@PathVariable String id) { service.delete(id); }
}