package com.tech.society.structure.controllers;

import com.tech.society.structure.models.SocietyMaintenanceSetting;
import com.tech.society.structure.services.SocietyMaintenanceSettingService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenance-settings")
public class SocietyMaintenanceSettingController {

    @Autowired
    private SocietyMaintenanceSettingService service;

    @PostMapping
    public SocietyMaintenanceSetting create(@RequestBody SocietyMaintenanceSetting setting, HttpServletRequest httpRequest) {
        return service.createSetting(setting);
    }

    @GetMapping
    public List<SocietyMaintenanceSetting> getAll(HttpServletRequest httpRequest) {

        return service.getAllSettings();
    }

    @GetMapping("/society/{societyId}")
    public SocietyMaintenanceSetting getBySociety(@PathVariable String societyIdentifer, HttpServletRequest httpRequest) {
        return service.getSettingsBySocietyIdentifier(societyIdentifer);
    }

    @PutMapping("/{id}")
    public SocietyMaintenanceSetting update(@PathVariable String id, @RequestBody SocietyMaintenanceSetting setting, HttpServletRequest httpRequest) {
        return service.updateSetting(id, setting);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id, HttpServletRequest httpRequest) {

        service.deleteSetting(id);
    }
}