package com.tech.society.structure.controllers;

import com.tech.society.structure.models.SocietyFlat;
import com.tech.society.structure.services.SocietyFlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flats")
public class SocietyFlatController {

    @Autowired
    private SocietyFlatService service;

    @PostMapping
    public SocietyFlat createFlat(@RequestBody SocietyFlat flat) {
        return service.createFlat(flat);
    }

    @GetMapping("/getAll")
    public List<SocietyFlat> getAll() {
        return service.getAllFlats();
    }

    @GetMapping("/society/{societyId}")
    public List<SocietyFlat> getBySocietyId(@PathVariable String societyId) {
        return service.getFlatsBySocietyIdentifier(societyId);
    }

    @PutMapping("/{id}")
    public SocietyFlat update(@PathVariable String id, @RequestBody SocietyFlat flat) {
        return service.updateFlat(id, flat);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteFlat(id);
    }
}