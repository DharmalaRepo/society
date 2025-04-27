package com.tech.society.structure.services;

import com.tech.society.structure.models.SocietyMaintenanceSetting;
import java.util.List;

public interface SocietyMaintenanceSettingService {
    SocietyMaintenanceSetting createSetting(SocietyMaintenanceSetting setting);
    List<SocietyMaintenanceSetting> getAllSettings();
    SocietyMaintenanceSetting getSettingsBySocietyIdentifier(String societyIentifier);
    SocietyMaintenanceSetting updateSetting(String id, SocietyMaintenanceSetting setting);
    void deleteSetting(String id);
}