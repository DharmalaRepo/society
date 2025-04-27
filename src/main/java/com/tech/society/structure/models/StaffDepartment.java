package com.example.societymanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "staff_departments")
public class StaffDepartment {

    @Id
    private String id;

    private String societyIdentifier; // To link it with the registered society
    private String departmentName; // e.g., "Security", "Housekeeping", "Electricians", "Plumbers", "Gardeners"
    private String description;

    private boolean active = true; // Active or not

    // Constructors
    public StaffDepartment() {}

    public StaffDepartment(String societyIdentifier, String departmentName, String description) {
        this.societyIdentifier = societyIdentifier;
        this.departmentName = departmentName;
        this.description = description;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}