package com.tech.society.structure.dto;

import com.tech.society.structure.dto.*;

import java.util.List;

public class SocietyRegistrationRequestDTO {
    private SocietyMasterDTO societyMaster;
    private List<SocietyFlatDTO> flats;
    private List<SocietyAmenityDTO> amenities;
    private List<SocietyParkingDTO> parkingSlots;
    private SocietyMaintenanceSettingDTO maintenanceSetting;
    private List<ExpenseCategoryDTO> expenseCategories;
    private List<StaffDepartmentDTO> staffDepartments;

    public SocietyMasterDTO getSocietyMaster() {
        return societyMaster;
    }

    public void setSocietyMaster(SocietyMasterDTO societyMaster) {
        this.societyMaster = societyMaster;
    }

    public List<SocietyFlatDTO> getFlats() {
        return flats;
    }

    public void setFlats(List<SocietyFlatDTO> flats) {
        this.flats = flats;
    }

    public List<SocietyAmenityDTO> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<SocietyAmenityDTO> amenities) {
        this.amenities = amenities;
    }

    public List<SocietyParkingDTO> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<SocietyParkingDTO> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public SocietyMaintenanceSettingDTO getMaintenanceSetting() {
        return maintenanceSetting;
    }

    public void setMaintenanceSetting(SocietyMaintenanceSettingDTO maintenanceSetting) {
        this.maintenanceSetting = maintenanceSetting;
    }

    public List<ExpenseCategoryDTO> getExpenseCategories() {
        return expenseCategories;
    }

    public void setExpenseCategories(List<ExpenseCategoryDTO> expenseCategories) {
        this.expenseCategories = expenseCategories;
    }

    public List<StaffDepartmentDTO> getStaffDepartments() {
        return staffDepartments;
    }

    public void setStaffDepartments(List<StaffDepartmentDTO> staffDepartments) {
        this.staffDepartments = staffDepartments;
    }
}