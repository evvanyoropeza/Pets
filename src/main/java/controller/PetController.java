package controller;

import dto.PetRequest;
import dto.PetResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.IPetService;

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
    public ResponseEntity<PetResponse> createPet(@RequestBody PetRequest request) {

        PetResponse response = petService.createPet(request);

        return ResponseEntity.ok(response);
    }
}