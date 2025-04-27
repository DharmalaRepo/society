package com.tech.society.structure.controllers;

import com.tech.society.structure.models.SocietyAmenity;
import com.tech.society.structure.services.SocietyAmenityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/amenities")
public class SocietyAmenityController {

    @Autowired
    private SocietyAmenityService service;

    @PostMapping
    public SocietyAmenity create(@RequestBody SocietyAmenity amenity) {
        return service.createAmenity(amenity);
    }

    @GetMapping
    public List<SocietyAmenity> getAll() {
        return service.getAllAmenities();
    }

    @GetMapping("/society/{societyId}")
    public List<SocietyAmenity> getBySociety(@PathVariable String societyId) {
        return service.getAmenitiesBySocietyIdentifier(societyId);
    }

    @PutMapping("/{id}")
    public SocietyAmenity update(@PathVariable String id, @RequestBody SocietyAmenity amenity) {
        return service.updateAmenity(id, amenity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteAmenity(id);
    }
}