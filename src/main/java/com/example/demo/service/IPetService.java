package com.example.demo.service;

import com.example.demo.dto.PetRequest;
import com.example.demo.dto.PetResponse;

public interface IPetService {

    PetResponse readById(Long idPet);
    PetResponse createPet(PetRequest request);
}
