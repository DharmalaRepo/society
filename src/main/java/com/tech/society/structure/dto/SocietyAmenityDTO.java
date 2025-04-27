package com.tech.society.structure.dto;

import com.tech.society.structure.models.SocietyAmenity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class SocietyAmenityDTO {

    @Id
    private String id;
    private int customId;
    private String societyIdentifier;
    private String name; // e.g., Gym, Clubhouse, Swimming Pool
    private String description;
    private String location;
    private int isActive;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCustomId() {
        return customId;
    }

    public void setCustomId(int customId) {
        this.customId = customId;
    }

    public String getSocietyIdentifier() {
        return societyIdentifier;
    }

    public void setSocietyIdentifier(String societyIdentifier) {
        this.societyIdentifier = societyIdentifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public SocietyAmenity toEntity() {
        SocietyAmenity entity = new SocietyAmenity();
        entity.setSocietyIdentifier(this.societyIdentifier);
        entity.setName(this.name);
        entity.setDescription(this.description);
        entity.setIsActive(1);
        return entity;
    }
}