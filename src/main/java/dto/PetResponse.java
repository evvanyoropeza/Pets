package dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PetResponse {
    private String transactionId;
    private LocalDateTime dateCreated;
    private Long id;
    private String name;
    private String status;
}
