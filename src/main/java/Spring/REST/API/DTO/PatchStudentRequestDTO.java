package Spring.REST.API.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PatchStudentRequestDTO {
    @Email
    private String email;
    @Size(min = 5, max = 50)
    private String name;
}
