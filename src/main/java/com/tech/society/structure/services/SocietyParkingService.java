package com.tech.society.structure.services;

import com.tech.society.structure.models.SocietyParking;

import java.util.List;

public interface SocietyParkingService {
    SocietyParking create(SocietyParking p);
    List<SocietyParking> getAll();
    List<SocietyParking> getBySocietyId(Integer id);
    SocietyParking update(String id, SocietyParking p);
    void delete(String id);
}