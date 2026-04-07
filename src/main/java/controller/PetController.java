package controller;

import entity.Pet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import repository.PetRepository;
import response.PetResponse;
import service.impl.PetService;

public class PetController {
    @GetMapping("/api/pet/{petId}")
    public ResponseEntity<PetResponse> readById(@PathVariable("idPet") Integer idPet) {
        try {
            PetResponse pet = PetService.readById(idPet);

            if (pet == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(pet);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
