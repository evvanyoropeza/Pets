package service;

import entity.Pet;
import response.PetResponse;

public interface IPetService {
    public PetResponse readById(Integer idPet);
}
