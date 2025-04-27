package com.tech.society.structure.repositories;

import com.tech.society.structure.models.SocietyMaster;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SocietyMasterRepository extends MongoRepository<SocietyMaster, String> {
    Optional<SocietyMaster> findBySocietyIdentifier(String societyIdentifier);
}