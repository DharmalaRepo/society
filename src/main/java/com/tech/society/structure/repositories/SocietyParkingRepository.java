package com.tech.society.structure.repositories;

import com.tech.society.structure.models.SocietyParking;
import com.tech.society.structure.models.SocietyMaster;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

import java.util.List;

public interface SocietyParkingRepository  extends MongoRepository<SocietyParking, String> {
    List<SocietyParking> findBySocietyId(Integer societyId);
}
