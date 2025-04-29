package com.tech.society.structure.controllers;

import com.example.societymanagement.model.StaffDepartment;
import com.tech.society.structure.dto.RequestContext;
import com.tech.society.structure.services.StaffDepartmentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff-departments")
public class StaffDepartmentController {

    @Autowired
    private final StaffDepartmentService staffDepartmentService;

    @Autowired
    public StaffDepartmentController(StaffDepartmentService staffDepartmentService, HttpServletRequest httpRequest) {
        RequestContext context = new RequestContext(httpRequest);
        this.staffDepartmentService = staffDepartmentService;
    }

    @PostMapping
    public StaffDepartment createStaffDepartment(@RequestBody StaffDepartment department, HttpServletRequest httpRequest) {
        RequestContext context = new RequestContext(httpRequest);
        return staffDepartmentService.createStaffDepartment(department);
    }

    @GetMapping("/{societyId}")
    public List<StaffDepartment> getAllStaffDepartments(@PathVariable String societyId, HttpServletRequest httpRequest) {
        RequestContext context = new RequestContext(httpRequest);
        return staffDepartmentService.getAllStaffDepartments(societyId);
    }

    @PutMapping("/{id}")
    public StaffDepartment updateStaffDepartment(@PathVariable String id, @RequestBody StaffDepartment department, HttpServletRequest httpRequest) {
        RequestContext context = new RequestContext(httpRequest);
        return staffDepartmentService.updateStaffDepartment(id, department);
    }

    @DeleteMapping("/{id}")
    public void deleteStaffDepartment(@PathVariable String id, HttpServletRequest httpRequest) {
        RequestContext context = new RequestContext(httpRequest);
        staffDepartmentService.deleteStaffDepartment(id);
    }
}