package com.tech.society.structure.services.impl;

import com.tech.society.structure.models.SocietyMaintenanceSetting;
import com.tech.society.structure.repositories.SocietyMaintenanceSettingRepository;
import com.tech.society.structure.services.SocietyMaintenanceSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocietyMaintenanceSettingServiceImpl implements SocietyMaintenanceSettingService {

    @Autowired
    private SocietyMaintenanceSettingRepository repository;

    @Override
    public SocietyMaintenanceSetting createSetting(SocietyMaintenanceSetting setting) {
        return repository.save(setting);
    }

    @Override
    public List<SocietyMaintenanceSetting> getAllSettings() {
        return repository.findAll();
    }

    @Override
    public SocietyMaintenanceSetting getSettingsBySocietyIdentifier(String societyIdentifier) {
        return repository.findBySocietyIdentifier(societyIdentifier);
    }

    @Override
    public SocietyMaintenanceSetting updateSetting(String id, SocietyMaintenanceSetting setting) {
        setting.setId(id);
        return repository.save(setting);
    }

    @Override
    public void deleteSetting(String id) {
        repository.deleteById(id);
    }
}