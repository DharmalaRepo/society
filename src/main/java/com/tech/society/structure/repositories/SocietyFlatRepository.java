package com.tech.society.structure.repositories;

import com.tech.society.structure.models.SocietyFlat;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SocietyFlatRepository extends MongoRepository<SocietyFlat, String> {
    List<SocietyFlat> findBySocietyId(Integer societyId);
}