package entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    private int idPet;
    private String name;
    private boolean status;


}
