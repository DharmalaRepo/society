package com.tech.society.structure.services.impl;

import com.tech.society.structure.models.SocietyParking;
import com.tech.society.structure.repositories.SocietyParkingRepository;
import com.tech.society.structure.services.SocietyParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocietyParkingServiceImpl implements SocietyParkingService {
    @Autowired
    SocietyParkingRepository repo;

    public SocietyParking create(SocietyParking p) { return repo.save(p); }
    public List<SocietyParking> getAll() { return repo.findAll(); }
    public List<SocietyParking> getBySocietyId(Integer id) { return repo.findBySocietyId(id); }
    public SocietyParking update(String id, SocietyParking p) { p.setId(id); return repo.save(p); }
    public void delete(String id) { repo.deleteById(id); }
}
