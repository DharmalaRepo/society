package com.tech.society.structure.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "expense_categories")
public class ExpenseCategory {

    @Id
    private String id;

    private String societyIdentifier; // To link it with the registered society
    private String categoryName; // e.g., "Electricity", "Water Charges", "Maintenance", "Security"
    private String description;

    private boolean active = true; // For soft delete/future deactivation

    // Constructors
    public ExpenseCategory() {}

    public ExpenseCategory(String societyIdentifier, String categoryName, String description) {
        this.societyIdentifier = societyIdentifier;
        this.categoryName = categoryName;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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