package service.impl;

import client.PetClient;
import dto.PetRequest;
import dto.PetResponse;
import model.Pet;
import service.IPetService;

import java.time.LocalDateTime;
import java.util.UUID;

public class PetService implements IPetService {

    private final PetClient petClient;

    public PetService(PetClient petClient) {
        this.petClient = petClient;
    }

    @Override
    public PetResponse readById(Long idPet) {

        Pet pet = petClient.getPet(idPet);

        // 🔥 requerido por el ejercicio
        System.out.println("Pet obtenida: " + pet);

        return new PetResponse(
                pet.getId(),
                pet.getName(),
                pet.getStatus()
        );
    }

    @Override
    public PetResponse createPet(PetRequest request) {

        Pet pet = petClient.createPet(request);

        // 🔥 requerido
        System.out.println("Pet creada: " + pet);

        String transactionId = UUID.randomUUID().toString();
        LocalDateTime dateCreated = LocalDateTime.now();

        return new PetResponse(
                transactionId,
                dateCreated,
                pet.getStatus(),
                pet.getName()
        );
    }
}