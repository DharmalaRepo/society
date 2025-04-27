package com.tech.society.structure.repositories;

import com.tech.society.structure.models.SocietyFlat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffDepartmentRepository extends MongoRepository<com.example.societymanagement.model.StaffDepartment, String> {
    List<com.example.societymanagement.model.StaffDepartment> findBySocietyIdentifier(String societyIdentifer);

}
