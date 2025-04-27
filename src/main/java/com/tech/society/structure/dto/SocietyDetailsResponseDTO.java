package com.tech.society.structure.dto;

import java.util.List;
import com.tech.society.structure.models.*;

public class SocietyDetailsResponseDTO {

    private SocietyMaster societyMaster;
    private List<SocietyFlat> flats;
    private List<SocietyAmenity> amenities;
    private List<SocietyParking> parkingSlots;
    private SocietyMaintenanceSetting maintenanceSetting;
    private List<ExpenseCategory> expenseCategories;
    private List<com.example.societymanagement.model.StaffDepartment> staffDepartments;

    public SocietyMaster getSocietyMaster() {
        return societyMaster;
    }

    public void setSocietyMaster(SocietyMaster societyMaster) {
        this.societyMaster = societyMaster;
    }

    public List<SocietyFlat> getFlats() {
        return flats;
    }

    public void setFlats(List<SocietyFlat> flats) {
        this.flats = flats;
    }

    public List<SocietyAmenity> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<SocietyAmenity> amenities) {
        this.amenities = amenities;
    }

    public List<SocietyParking> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<SocietyParking> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public SocietyMaintenanceSetting getMaintenanceSetting() {
        return maintenanceSetting;
    }

    public void setMaintenanceSetting(SocietyMaintenanceSetting maintenanceSetting) {
        this.maintenanceSetting = maintenanceSetting;
    }

    public List<ExpenseCategory> getExpenseCategories() {
        return expenseCategories;
    }

    public void setExpenseCategories(List<ExpenseCategory> expenseCategories) {
        this.expenseCategories = expenseCategories;
    }

    public List<com.example.societymanagement.model.StaffDepartment> getStaffDepartments() {
        return staffDepartments;
    }

    public void setStaffDepartments(List<com.example.societymanagement.model.StaffDepartment> staffDepartments) {
        this.staffDepartments = staffDepartments;
    }
}
