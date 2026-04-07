package com.example.demo.service.impl;

import com.example.demo.client.PetClient;
import com.example.demo.dto.PetRequest;
import com.example.demo.dto.PetResponse;
import com.example.demo.model.Pet;
import com.example.demo.service.IPetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PetService implements IPetService {

    private static final Logger log = LoggerFactory.getLogger(PetService.class);

    private final PetClient petClient;

    public PetService(PetClient petClient) {
        this.petClient = petClient;
    }

    @Override
    public PetResponse readById(Long idPet) {

        log.info("Consultando mascota con id: {}", idPet);

        Pet pet = petClient.getPet(idPet);

        if (pet == null) {
            throw new RuntimeException("No se encontró la mascota con id: " + idPet);
        }

        log.info("Respuesta obtenida: {}", pet);

        return new PetResponse(
                pet.getId(),
                pet.getName(),
                pet.getStatus()
        );
    }

    @Override
    public PetResponse createPet(PetRequest request) {

        log.info("Creando mascota: {}", request);

        Pet pet = petClient.createPet(request);

        if (pet == null) {
            throw new RuntimeException("Error al crear la mascota");
        }

        String transactionId = UUID.randomUUID().toString();
        LocalDateTime dateCreated = LocalDateTime.now();

        log.info("Respuesta externa: {}", pet);
        log.info("transactionId generado: {}", transactionId);

        return new PetResponse(
                transactionId,
                dateCreated,
                pet.getStatus(),
                pet.getName()
        );
    }
}