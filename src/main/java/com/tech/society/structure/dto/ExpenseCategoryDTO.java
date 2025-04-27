package com.tech.society.structure.dto;

import com.tech.society.structure.models.ExpenseCategory;

public class ExpenseCategoryDTO {

    private String societyIdentifier; // To link it with the registered society
    private String categoryName; // e.g., "Electricity", "Water Charges", "Maintenance", "Security"
    private String description;

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

    public ExpenseCategory toEntity() {
        ExpenseCategory entity = new ExpenseCategory();
        entity.setSocietyIdentifier(this.societyIdentifier);
        entity.setCategoryName(this.categoryName);
        entity.setDescription(this.description);
        entity.setActive(true);
        return entity;
    }
}
