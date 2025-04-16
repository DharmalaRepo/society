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
    public SocietyMaster getSocietyByCustomId(Integer customId) {
        return societyMasterRepo.findByCustomId(customId)
                .orElseThrow(() -> new RuntimeException("Society not found"));
    }

    @Override
    public List<SocietyFlat> getFlatsBySocietyId(Integer societyId) {
        return flatRepo.findBySocietyId(societyId);
    }

    @Override
    public List<SocietyParking> getParkingBySocietyId(Integer societyId) {
        return parkingRepo.findBySocietyId(societyId);
    }

    @Override
    public List<SocietyAmenity> getAmenitiesBySocietyId(Integer societyId) {
        return amenityRepo.findBySocietyId(societyId);
    }

    @Override
    public List<SocietyMaintenanceSetting> getMaintenanceSettingsBySocietyId(Integer societyId) {
        return maintenanceRepo.findBySocietyId(societyId);
    }
}