package response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PetResponse {
    private int idPet;
    private String name;
    private boolean status;
}
