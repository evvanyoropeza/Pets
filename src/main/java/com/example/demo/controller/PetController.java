package com.example.demo.controller;

import com.example.demo.dto.PetRequest;
import com.example.demo.dto.PetResponse;
import com.example.demo.service.IPetService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pet")
public class PetController {

    private final IPetService petService;

    public PetController(IPetService petService) {
        this.petService = petService;
    }

    @GetMapping("/{petId}")
    public ResponseEntity<PetResponse> readById(@PathVariable Long petId) {

        PetResponse response = petService.readById(petId);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<PetResponse> createPet(@Valid @RequestBody PetRequest request) {

        PetResponse response = petService.createPet(request);

        return ResponseEntity.status(201).body(response);
    }
}