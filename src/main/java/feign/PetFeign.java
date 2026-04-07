package feign;
import entity.Pet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "clienteExterno", url = "https://petstore.swagger.io/#/")

public interface PetFeign {
    @GetMapping("/pet/{petId}")
    public Optional<Pet> readById(@PathVariable() Integer idCteExt);

}
