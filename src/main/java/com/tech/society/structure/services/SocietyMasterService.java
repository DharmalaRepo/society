package com.tech.society.structure.services;

import com.tech.society.structure.models.*;
import java.util.List;

public interface SocietyMasterService {
    SocietyMaster createSociety(SocietyMaster societyMaster);
    List<SocietyMaster> getAllSocieties();
    SocietyMaster getSocietyBySocietyIdentifer(String societyIdentifer);

    List<SocietyFlat> getFlatsBySocietyIdentifer(String societyIdentifer);
    List<SocietyParking> getParkingBySocietyIdentifer(String societyIdentifer);
    List<SocietyAmenity> getAmenitiesBySocietyIdentifer(String societyIdentifer);
    SocietyMaintenanceSetting getMaintenanceSettingsBySocietyIdentifer(String societyIdentifer);




}