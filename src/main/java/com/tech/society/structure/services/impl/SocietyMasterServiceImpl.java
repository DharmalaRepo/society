package com.tech.society.structure.services.impl;

import com.tech.society.structure.models.*;
import com.tech.society.structure.repositories.*;
import com.tech.society.structure.services.SocietyMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocietyMasterServiceImpl implements SocietyMasterService {

    @Autowired private SocietyMasterRepository societyMasterRepo;
    @Autowired private SocietyFlatRepository flatRepo;
    @Autowired private SocietyParkingRepository parkingRepo;
    @Autowired private SocietyAmenityRepository amenityRepo;
    @Autowired private SocietyMaintenanceSettingRepository maintenanceRepo;

    @Override
    public SocietyMaster createSociety(SocietyMaster societyMaster) {
        return societyMasterRepo.save(societyMaster);
    }

    @Override
    public List<SocietyMaster> getAllSocieties() {
        return societyMasterRepo.findAll();
    }

    @Override
    public SocietyMaster getSocietyBySocietyIdentifer(String societyIdentifer) {
        return societyMasterRepo.findBySocietyIdentifier(societyIdentifer)
                .orElseThrow(() -> new RuntimeException("Society not found"));
    }

    @Override
    public List<SocietyFlat> getFlatsBySocietyIdentifer(String societyIdentifer) {
        return flatRepo.findBySocietyIdentifier(societyIdentifer);
    }

    @Override
    public List<SocietyParking> getParkingBySocietyIdentifer(String societyIdentifer) {
        return parkingRepo.findBySocietyIdentifier(societyIdentifer);
    }

    @Override
    public List<SocietyAmenity> getAmenitiesBySocietyIdentifer(String societyIdentifer) {
        return amenityRepo.findBySocietyIdentifier(societyIdentifer);
    }

    @Override
    public SocietyMaintenanceSetting getMaintenanceSettingsBySocietyIdentifer(String societyIdentifer) {
        return maintenanceRepo.findBySocietyIdentifier(societyIdentifer);
    }
}