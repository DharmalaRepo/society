package com.tech.society.structure.services;

import com.tech.society.structure.dto.AdminRegistrationRequest;
import com.tech.society.structure.dto.SocietyDetailsResponseDTO;
import com.tech.society.structure.dto.SocietyRegistrationRequestDTO;
import com.tech.society.structure.models.*;
import com.tech.society.structure.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.List;

@Service
public class SocietyRegistrationService {

    @Value("${login.service.base.url}")
    private String loginServiceBaseUrl;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private final SocietyMasterRepository societyMasterRepository;
    @Autowired
    private final SocietyFlatRepository societyFlatRepository;
    @Autowired
    private final SocietyAmenityRepository societyAmenityRepository;
    @Autowired
    private final SocietyParkingRepository societyParkingRepository;
    @Autowired
    private final SocietyMaintenanceSettingRepository societyMaintenanceSettingRepository;
    @Autowired
    private final ExpenseCategoryRepository expenseCategoryRepository;
    @Autowired
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

        AdminRegistrationRequest admin = new AdminRegistrationRequest(request.getAdmin(), request.getSocietyMaster().getRegistrationNumber());
        registerAdmin(admin);

    }



    public String registerAdmin(AdminRegistrationRequest request) {
        String targetUrl = "http://localhost:9091/api/users/register-admin";  // Replace with actual URL

        // Step 1: Build headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Basic Auth Header
        String plainCreds = "admin:admin123";
        String base64Creds = Base64.getEncoder().encodeToString(plainCreds.getBytes());
        headers.add("Authorization", "Basic " + base64Creds);

        // Step 2: Build request entity (body + headers)
        HttpEntity<AdminRegistrationRequest> entity = new HttpEntity<>(request, headers);

        // Step 3: Make the REST call
        ResponseEntity<String> response = restTemplate.exchange(
                targetUrl,
                HttpMethod.POST,
                entity,
                String.class
        );

        return response.getBody();
    }


    public SocietyDetailsResponseDTO getSocietyDetails(String societyIdentifier) {
        SocietyDetailsResponseDTO response = new SocietyDetailsResponseDTO();

        SocietyMaster master = societyMasterRepository.findBySocietyIdentifier(societyIdentifier)
                .orElseThrow(() -> new RuntimeException("Society not found"));

        List<SocietyFlat> flats = societyFlatRepository.findBySocietyIdentifier(societyIdentifier);
        List<SocietyAmenity> amenities = societyAmenityRepository.findBySocietyIdentifier(societyIdentifier);
        List<SocietyParking> parkings = societyParkingRepository.findBySocietyIdentifier(societyIdentifier);
        SocietyMaintenanceSetting maintenanceSetting = societyMaintenanceSettingRepository.findBySocietyIdentifier(societyIdentifier);
        List<ExpenseCategory> expenseCategories = expenseCategoryRepository.findBySocietyIdentifier(societyIdentifier);
        List<com.example.societymanagement.model.StaffDepartment> staffDepartments = staffDepartmentRepository.findBySocietyIdentifier(societyIdentifier);

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