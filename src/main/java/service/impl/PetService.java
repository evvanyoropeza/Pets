package service.impl;

import entity.Pet;
import repository.PetRepository;
import response.PetResponse;
import service.IPetService;

public class PetService implements IPetService {
    @Override
    public PetResponse readById(Integer idPet) {
        return PetRepository.findById(idPet)
                .map(Pet::toResponse)
                .orElse(null);
    }
}
