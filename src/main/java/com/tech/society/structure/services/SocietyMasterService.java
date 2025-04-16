package com.tech.society.structure.services;

import com.tech.society.structure.models.*;
import java.util.List;

public interface SocietyMasterService {
    SocietyMaster createSociety(SocietyMaster societyMaster);
    List<SocietyMaster> getAllSocieties();
    SocietyMaster getSocietyByCustomId(Integer customId);

    List<SocietyFlat> getFlatsBySocietyId(Integer societyId);
    List<SocietyParking> getParkingBySocietyId(Integer societyId);
    List<SocietyAmenity> getAmenitiesBySocietyId(Integer societyId);
    List<SocietyMaintenanceSetting> getMaintenanceSettingsBySocietyId(Integer societyId);
}