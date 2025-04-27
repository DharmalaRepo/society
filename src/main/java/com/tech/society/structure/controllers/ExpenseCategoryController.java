package com.tech.society.structure.controllers;


import com.tech.society.structure.models.ExpenseCategory;
import com.tech.society.structure.services.ExpenseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense-categories")
public class ExpenseCategoryController {

    private final ExpenseCategoryService expenseCategoryService;

    @Autowired
    public ExpenseCategoryController(ExpenseCategoryService expenseCategoryService) {
        this.expenseCategoryService = expenseCategoryService;
    }

    @PostMapping
    public ExpenseCategory createExpenseCategory(@RequestBody ExpenseCategory category) {
        return expenseCategoryService.createExpenseCategory(category);
    }

    @GetMapping("/{societyId}")
    public List<ExpenseCategory> getAllExpenseCategories(@PathVariable String societyId) {
        return expenseCategoryService.getAllExpenseCategories(societyId);
    }

    @PutMapping("/{id}")
    public ExpenseCategory updateExpenseCategory(@PathVariable String id, @RequestBody ExpenseCategory category) {
        return expenseCategoryService.updateExpenseCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteExpenseCategory(@PathVariable String id) {
        expenseCategoryService.deleteExpenseCategory(id);
    }
}