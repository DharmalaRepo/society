package com.tech.society.structure.services;

import com.tech.society.structure.models.ExpenseCategory;
import com.tech.society.structure.repositories.ExpenseCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseCategoryService {

    private final ExpenseCategoryRepository expenseCategoryRepository;

    @Autowired
    public ExpenseCategoryService(ExpenseCategoryRepository expenseCategoryRepository) {
        this.expenseCategoryRepository = expenseCategoryRepository;
    }

    public ExpenseCategory createExpenseCategory(ExpenseCategory category) {
        return expenseCategoryRepository.save(category);
    }

    public List<ExpenseCategory> getAllExpenseCategories(String societyId) {
        return expenseCategoryRepository.findBySocietyIdentifier(societyId);
    }

    public ExpenseCategory updateExpenseCategory(String id, ExpenseCategory updatedCategory) {
        ExpenseCategory category = expenseCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense Category not found"));
        category.setCategoryName(updatedCategory.getCategoryName());
        category.setDescription(updatedCategory.getDescription());
        category.setActive(updatedCategory.isActive());
        return expenseCategoryRepository.save(category);
    }

    public void deleteExpenseCategory(String id) {
        expenseCategoryRepository.deleteById(id);
    }
}