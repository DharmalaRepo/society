package com.tech.society.structure.controllers;

import com.tech.society.structure.models.SocietyMaintenanceSetting;
import com.tech.society.structure.services.SocietyMaintenanceSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenance-settings")
public class SocietyMaintenanceSettingController {

    @Autowired
    private SocietyMaintenanceSettingService service;

    @PostMapping
    public SocietyMaintenanceSetting create(@RequestBody SocietyMaintenanceSetting setting) {
        return service.createSetting(setting);
    }

    @GetMapping
    public List<SocietyMaintenanceSetting> getAll() {
        return service.getAllSettings();
    }

    @GetMapping("/society/{societyId}")
    public SocietyMaintenanceSetting getBySociety(@PathVariable String societyIdentifer) {
        return service.getSettingsBySocietyIdentifier(societyIdentifer);
    }

    @PutMapping("/{id}")
    public SocietyMaintenanceSetting update(@PathVariable String id, @RequestBody SocietyMaintenanceSetting setting) {
        return service.updateSetting(id, setting);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteSetting(id);
    }
}