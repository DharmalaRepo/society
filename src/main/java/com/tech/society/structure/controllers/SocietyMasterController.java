package com.tech.society.structure.controllers;

import com.tech.society.structure.models.*;
import com.tech.society.structure.services.SocietyMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/societies")
public class SocietyMasterController {

    @Autowired
    private SocietyMasterService service;

    @PostMapping
    public SocietyMaster createSociety(@RequestBody SocietyMaster society) {
        return service.createSociety(society);
    }

    @GetMapping
    public List<SocietyMaster> getAllSocieties() {
        return service.getAllSocieties();
    }

    @GetMapping("/{customId}")
    public SocietyMaster getSociety(@PathVariable Integer customId) {
        return service.getSocietyByCustomId(customId);
    }

    @GetMapping("/{customId}/flats")
    public List<SocietyFlat> getFlats(@PathVariable Integer customId) {
        return service.getFlatsBySocietyId(customId);
    }

    @GetMapping("/{customId}/parking")
    public List<SocietyParking> getParking(@PathVariable Integer customId) {
        return service.getParkingBySocietyId(customId);
    }

    @GetMapping("/{customId}/amenities")
    public List<SocietyAmenity> getAmenities(@PathVariable Integer customId) {
        return service.getAmenitiesBySocietyId(customId);
    }

    @GetMapping("/{customId}/maintenance")
    public List<SocietyMaintenanceSetting> getMaintenance(@PathVariable Integer customId) {
        return service.getMaintenanceSettingsBySocietyId(customId);
    }
}