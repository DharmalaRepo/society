package com.tech.society.structure.services.impl;

import com.tech.society.structure.models.SocietyFlat;
import com.tech.society.structure.repositories.SocietyFlatRepository;
import com.tech.society.structure.services.SocietyFlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocietyFlatServiceImpl implements SocietyFlatService {

    @Autowired
    private SocietyFlatRepository repo;

    @Override
    public SocietyFlat createFlat(SocietyFlat flat) {
        return repo.save(flat);
    }

    @Override
    public List<SocietyFlat> getAllFlats() {
        return repo.findAll();
    }

    @Override
    public List<SocietyFlat> getFlatsBySocietyId(Integer societyId) {
        return repo.findBySocietyId(societyId);
    }

    @Override
    public SocietyFlat updateFlat(String id, SocietyFlat flat) {
        flat.setId(id);
        return repo.save(flat);
    }

    @Override
    public void deleteFlat(String id) {
        repo.deleteById(id);
    }
}