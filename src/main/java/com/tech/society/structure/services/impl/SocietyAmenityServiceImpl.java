package com.tech.society.structure.services.impl;

import com.tech.society.structure.models.SocietyAmenity;
import com.tech.society.structure.repositories.SocietyAmenityRepository;
import com.tech.society.structure.services.SocietyAmenityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocietyAmenityServiceImpl implements SocietyAmenityService {

    @Autowired
    private SocietyAmenityRepository repository;

    @Override
    public SocietyAmenity createAmenity(SocietyAmenity amenity) {
        return repository.save(amenity);
    }

    @Override
    public List<SocietyAmenity> getAllAmenities() {
        return repository.findAll();
    }

    @Override
    public List<SocietyAmenity> getAmenitiesBySocietyId(Integer societyId) {
        return repository.findBySocietyId(societyId);
    }

    @Override
    public SocietyAmenity updateAmenity(String id, SocietyAmenity amenity) {
        amenity.setId(id);
        return repository.save(amenity);
    }

    @Override
    public void deleteAmenity(String id) {
        repository.deleteById(id);
    }
}