package com.example.demo.client;

import com.example.demo.dto.PetRequest;
import com.example.demo.model.Pet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "petClient", url = "https://petstore.swagger.io/v2")
public interface PetClient {

    @GetMapping("/pet/{id}")
    Pet getPet(@PathVariable("id") Long id);

    @PostMapping("/pet")
    Pet createPet(@RequestBody PetRequest request);
}