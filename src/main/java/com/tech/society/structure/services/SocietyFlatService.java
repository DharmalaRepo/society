package com.tech.society.structure.services;

import com.tech.society.structure.models.SocietyFlat;
import java.util.List;

public interface SocietyFlatService {
    SocietyFlat createFlat(SocietyFlat flat);
    List<SocietyFlat> getAllFlats(String societyIdentifier);
    List<SocietyFlat> getFlatsBySocietyIdentifier(String societyId);
    SocietyFlat updateFlat(String id, SocietyFlat flat);
    void deleteFlat(String id);
}