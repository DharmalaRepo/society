package com.tech.society.structure.controllers;

import com.tech.society.structure.dto.SocietyDetailsResponseDTO;
import com.tech.society.structure.dto.SocietyRegistrationRequestDTO;
import com.tech.society.structure.services.SocietyRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/societies")
public class SocietyRegistrationController {

    @Autowired
    private SocietyRegistrationService societyRegistrationService;

    @PostMapping("/register")
    public ResponseEntity<String> registerSociety(@RequestBody SocietyRegistrationRequestDTO request) {
        societyRegistrationService.registerSociety(request);
        return ResponseEntity.ok("Society registered successfully!");
    }

    @GetMapping("/{societyId}")
    public ResponseEntity<SocietyDetailsResponseDTO> getSocietyDetails(@PathVariable String societyId) {
        SocietyDetailsResponseDTO societyDetails = societyRegistrationService.getSocietyDetails(societyId);
        return ResponseEntity.ok(societyDetails);
    }
}