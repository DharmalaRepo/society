package com.tech.society.structure.controllers;

import com.example.societymanagement.model.StaffDepartment;
import com.tech.society.structure.services.StaffDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff-departments")
public class StaffDepartmentController {

    @Autowired
    private final StaffDepartmentService staffDepartmentService;

    @Autowired
    public StaffDepartmentController(StaffDepartmentService staffDepartmentService) {
        this.staffDepartmentService = staffDepartmentService;
    }

    @PostMapping
    public StaffDepartment createStaffDepartment(@RequestBody StaffDepartment department) {
        return staffDepartmentService.createStaffDepartment(department);
    }

    @GetMapping("/{societyId}")
    public List<StaffDepartment> getAllStaffDepartments(@PathVariable String societyId) {
        return staffDepartmentService.getAllStaffDepartments(societyId);
    }

    @PutMapping("/{id}")
    public StaffDepartment updateStaffDepartment(@PathVariable String id, @RequestBody StaffDepartment department) {
        return staffDepartmentService.updateStaffDepartment(id, department);
    }

    @DeleteMapping("/{id}")
    public void deleteStaffDepartment(@PathVariable String id) {
        staffDepartmentService.deleteStaffDepartment(id);
    }
}