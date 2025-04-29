package com.tech.society.structure.controllers;

import com.tech.society.structure.models.SocietyFlat;
import com.tech.society.structure.models.SocietyParking;
import com.tech.society.structure.services.SocietyFlatService;
import com.tech.society.structure.services.SocietyParkingService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parking")
public class SocietyParkingController {
    @Autowired
    SocietyParkingService service;

    @PostMapping
    public SocietyParking create(@RequestBody SocietyParking p, HttpServletRequest httpRequest) {
        return service.create(p);
    }

    @GetMapping
    public List<SocietyParking> getAll(HttpServletRequest httpRequest) {
        return service.getAll();
    }

    @GetMapping("/society/{id}")
    public List<SocietyParking> getBySociety(@PathVariable String id, HttpServletRequest httpRequest) {
        return service.getBySocietyIdentifier(id);
    }

    @PutMapping("/{id}")
    public SocietyParking update(@PathVariable String id, @RequestBody SocietyParking p, HttpServletRequest httpRequest) {
        return service.update(id, p);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id, HttpServletRequest httpRequest) {
        service.delete(id);
    }
}