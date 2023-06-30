package med.voli.api.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voli.api.address.DataAddress;

public record DataCreationDoctor(
    @NotBlank
    String nome, 
    @NotBlank
    @Email
    String email, 
    @NotBlank
    String cellphone,
    @NotBlank
    @Pattern(regexp = "\\d{4,6}")
    String crm, 
    @NotNull
    Speciality speciality, 
    @NotNull
    @Valid
    DataAddress dataAddress
    ) {
    
}
