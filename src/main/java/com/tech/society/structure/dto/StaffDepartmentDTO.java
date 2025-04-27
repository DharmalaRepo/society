package com.tech.society.structure.dto;

public class StaffDepartmentDTO {
    private String societyIdentifier; // To link it with the registered society
    private String departmentName; // e.g., "Security", "Housekeeping", "Electricians", "Plumbers", "Gardeners"
    private String description;

    public StaffDepartmentDTO() {
    }

    public String getSocietyIdentifier() {
        return societyIdentifier;
    }

    public void setSocietyIdentifier(String societyIdentifier) {
        this.societyIdentifier = societyIdentifier;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public com.example.societymanagement.model.StaffDepartment toEntity() {
        com.example.societymanagement.model.StaffDepartment entity = new com.example.societymanagement.model.StaffDepartment();
        entity.setSocietyIdentifier(this.societyIdentifier);
        entity.setDepartmentName(this.departmentName);
        entity.setDescription(this.description);
        entity.setActive(true);
        return entity;
    }
}
