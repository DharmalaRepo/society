package com.tech.society.structure.controllers;

import com.tech.society.structure.dto.RequestContext;
import com.tech.society.structure.models.SocietyFlat;
import com.tech.society.structure.services.SocietyFlatService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flats")
public class SocietyFlatController {

    @Autowired
    private SocietyFlatService service;

    @PostMapping
    public SocietyFlat createFlat(@RequestBody SocietyFlat flat, HttpServletRequest httpRequest) {

        return service.createFlat(flat);
    }

    @GetMapping("/getAll")
    public List<SocietyFlat> getAll(HttpServletRequest httpRequest) {
        RequestContext context = new RequestContext(httpRequest);
        return service.getAllFlats(context.getSocietyIdentifier());
    }

    @GetMapping("/society/{societyId}")
    public List<SocietyFlat> getBySocietyId(@PathVariable String societyId, HttpServletRequest httpRequest) {
        return service.getFlatsBySocietyIdentifier(societyId);
    }

    @PutMapping("/{id}")
    public SocietyFlat update(@PathVariable String id, @RequestBody SocietyFlat flat, HttpServletRequest httpRequest) {
        return service.updateFlat(id, flat);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id, HttpServletRequest httpRequest) {

        service.deleteFlat(id);
    }


}