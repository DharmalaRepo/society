package com.tech.society.structure.dto;

import com.tech.society.structure.models.SocietyFlat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class SocietyFlatDTO {

    @Id
    private String id;
    private int customId;
    private String societyIdentifier;
    private String flatNumber;
    private String blockName;
    private String floor;
    private String type; // 1BHK, 2BHK, Duplex, etc.
    private double areaInSqFt;
    private boolean isOccupied;
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

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAreaInSqFt() {
        return areaInSqFt;
    }

    public void setAreaInSqFt(double areaInSqFt) {
        this.areaInSqFt = areaInSqFt;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public SocietyFlat toEntity() {
        SocietyFlat entity = new SocietyFlat();
        entity.setSocietyIdentifier(this.societyIdentifier);
        entity.setBlockName(this.blockName);
        entity.setFlatNumber(this.flatNumber);
        entity.setType(this.type);
        entity.setIsActive(1);
        return entity;
    }
}