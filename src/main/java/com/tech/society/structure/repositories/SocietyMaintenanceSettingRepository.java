package com.tech.society.structure.repositories;

import com.tech.society.structure.models.SocietyMaintenanceSetting;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SocietyMaintenanceSettingRepository extends MongoRepository<SocietyMaintenanceSetting, String> {
    SocietyMaintenanceSetting findBySocietyIdentifier(String societyId);
}