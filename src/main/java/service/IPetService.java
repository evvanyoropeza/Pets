package service;

import dto.PetRequest;
import dto.PetResponse;

public interface IPetService {

    PetResponse readById(Integer idPet);

    PetResponse createPet(PetRequest request);
}
