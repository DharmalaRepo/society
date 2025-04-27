package com.tech.society.structure.services;

import com.example.societymanagement.model.StaffDepartment;

import com.tech.society.structure.repositories.StaffDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffDepartmentService {

    @Autowired
    private final StaffDepartmentRepository staffDepartmentRepository;

    @Autowired
    public StaffDepartmentService(StaffDepartmentRepository staffDepartmentRepository) {
        this.staffDepartmentRepository = staffDepartmentRepository;
    }

    public StaffDepartment createStaffDepartment(StaffDepartment department) {
        return staffDepartmentRepository.save(department);
    }

    public List<StaffDepartment> getAllStaffDepartments(String societyId) {
        return staffDepartmentRepository.findBySocietyIdentifier(societyId);
    }

    public StaffDepartment updateStaffDepartment(String id, StaffDepartment updatedDepartment) {
        StaffDepartment department = staffDepartmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff Department not found"));
        department.setDepartmentName(updatedDepartment.getDepartmentName());
        department.setDescription(updatedDepartment.getDescription());
        department.setActive(updatedDepartment.isActive());
        return staffDepartmentRepository.save(department);
    }

    public void deleteStaffDepartment(String id) {
        staffDepartmentRepository.deleteById(id);
    }
}