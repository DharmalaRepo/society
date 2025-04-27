package com.tech.society.structure.services;

import com.tech.society.structure.models.SocietyAmenity;
import java.util.List;

public interface SocietyAmenityService {
    SocietyAmenity createAmenity(SocietyAmenity amenity);
    List<SocietyAmenity> getAllAmenities();
    List<SocietyAmenity> getAmenitiesBySocietyIdentifier(String societyIdentifier);
    SocietyAmenity updateAmenity(String id, SocietyAmenity amenity);
    void deleteAmenity(String id);
}