package com.tech.society.structure.dto;

import com.tech.society.structure.models.SocietyMaintenanceSetting;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

public class SocietyMaintenanceSettingDTO {

    @Id
    private String id;
    private int customId;
    private String societyIdentifier;
    private String frequency; // Monthly, Quarterly, etc.
    private double amount;
    private LocalDate dueDate;
    private double lateFee;
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

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public double getLateFee() {
        return lateFee;
    }

    public void setLateFee(double lateFee) {
        this.lateFee = lateFee;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public SocietyMaintenanceSetting toEntity() {
        SocietyMaintenanceSetting entity = new SocietyMaintenanceSetting();
        entity.setSocietyIdentifier(this.societyIdentifier);
        entity.setFrequency(this.frequency);
        entity.setAmount(this.amount);
        entity.setDueDate(dueDate);
        return entity;
    }
}