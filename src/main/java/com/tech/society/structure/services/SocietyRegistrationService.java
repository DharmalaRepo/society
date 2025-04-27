package com.tech.society.structure.services;

import com.tech.society.structure.dto.SocietyDetailsResponseDTO;
import com.tech.society.structure.dto.SocietyRegistrationRequestDTO;
import com.tech.society.structure.models.*;
import com.tech.society.structure.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocietyRegistrationService {

    private final SocietyMasterRepository societyMasterRepository;
    private final SocietyFlatRepository societyFlatRepository;
    private final SocietyAmenityRepository societyAmenityRepository;
    private final SocietyParkingRepository societyParkingRepository;
    private final SocietyMaintenanceSettingRepository societyMaintenanceSettingRepository;
    private final ExpenseCategoryRepository expenseCategoryRepository;
    private final StaffDepartmentRepository staffDepartmentRepository;

    @Autowired
    public SocietyRegistrationService(
            SocietyMasterRepository societyMasterRepository,
            SocietyFlatRepository societyFlatRepository,
            SocietyAmenityRepository societyAmenityRepository,
            SocietyParkingRepository societyParkingRepository,
            SocietyMaintenanceSettingRepository societyMaintenanceSettingRepository,
            ExpenseCategoryRepository expenseCategoryRepository,
            StaffDepartmentRepository staffDepartmentRepository
    ) {
        this.societyMasterRepository = societyMasterRepository;
        this.societyFlatRepository = societyFlatRepository;
        this.societyAmenityRepository = societyAmenityRepository;
        this.societyParkingRepository = societyParkingRepository;
        this.societyMaintenanceSettingRepository = societyMaintenanceSettingRepository;
        this.expenseCategoryRepository = expenseCategoryRepository;
        this.staffDepartmentRepository = staffDepartmentRepository;
    }

    public void registerSociety(SocietyRegistrationRequestDTO request) {
        SocietyMaster master = request.getSocietyMaster().toEntity();
        master.setSocietyIdentifier(request.getSocietyMaster().getRegistrationNumber());
        societyMasterRepository.save(master);

        // Save Flats
        if(null!=request.getFlats() && request.getFlats().size()>0){
            request.getFlats().forEach(flatDTO -> {
                SocietyFlat flat = flatDTO.toEntity();
                flat.setSocietyIdentifier(request.getSocietyMaster().getRegistrationNumber());
                societyFlatRepository.save(flat);
            });
        }



        // Save Amenities
        if(null!=request.getAmenities() && request.getAmenities().size()>0){
            request.getAmenities().forEach(amenityDTO -> {
                SocietyAmenity amenity = amenityDTO.toEntity();
                amenity.setSocietyIdentifier(request.getSocietyMaster().getRegistrationNumber());
                societyAmenityRepository.save(amenity);
            });
        }


        // Save Parking
        if(null!=request.getParkingSlots() && request.getParkingSlots().size()>0){
            request.getParkingSlots().forEach(parkingDTO -> {
                SocietyParking parking = parkingDTO.toEntity();
                parking.setSocietyIdentifier(request.getSocietyMaster().getRegistrationNumber());
                societyParkingRepository.save(parking);
            });
        }


        // Save Maintenance Settings
        if(null!=request.getMaintenanceSetting() ){
            SocietyMaintenanceSetting setting = request.getMaintenanceSetting().toEntity();
            setting.setSocietyIdentifier(request.getSocietyMaster().getRegistrationNumber());
            societyMaintenanceSettingRepository.save(setting);
        }


        // Save Expense Categories
        if(null!=request.getExpenseCategories() && request.getExpenseCategories().size()>0){
            request.getExpenseCategories().forEach(expenseDTO -> {
                ExpenseCategory expense = expenseDTO.toEntity();
                expense.setSocietyIdentifier(request.getSocietyMaster().getRegistrationNumber());
                expenseCategoryRepository.save(expense);
            });
        }


        // Save Staff Departments
        if(null!=request.getStaffDepartments() && request.getStaffDepartments().size()>0){
            request.getStaffDepartments().forEach(deptDTO -> {
                com.example.societymanagement.model.StaffDepartment department = deptDTO.toEntity();
                department.setSocietyIdentifier(request.getSocietyMaster().getRegistrationNumber());
                staffDepartmentRepository.save(department);
            });
        }

    }


    public SocietyDetailsResponseDTO getSocietyDetails(String societyId) {
        SocietyDetailsResponseDTO response = new SocietyDetailsResponseDTO();

        SocietyMaster master = societyMasterRepository.findById(societyId)
                .orElseThrow(() -> new RuntimeException("Society not found"));

        List<SocietyFlat> flats = societyFlatRepository.findBySocietyIdentifier(societyId);
        List<SocietyAmenity> amenities = societyAmenityRepository.findBySocietyIdentifier(societyId);
        List<SocietyParking> parkings = societyParkingRepository.findBySocietyIdentifier(societyId);
        SocietyMaintenanceSetting maintenanceSetting = societyMaintenanceSettingRepository.findBySocietyIdentifier(societyId);
        List<ExpenseCategory> expenseCategories = expenseCategoryRepository.findBySocietyIdentifier(societyId);
        List<com.example.societymanagement.model.StaffDepartment> staffDepartments = staffDepartmentRepository.findBySocietyIdentifier(societyId);

        // Set to response
        response.setSocietyMaster(master);
        response.setFlats(flats);
        response.setAmenities(amenities);
        response.setParkingSlots(parkings);
        response.setMaintenanceSetting(maintenanceSetting);
        response.setExpenseCategories(expenseCategories);
        response.setStaffDepartments(staffDepartments);

        return response;
    }
}