package med.voli.api.domain.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DataAddress(
    @NotBlank
    String street, 
    @NotBlank
    String neighbourhood, 
    @NotBlank
    @Pattern(regexp = "\\d{5}-\\d{3}")
    String postal_code,
    @NotBlank
    String city, 
    @NotBlank
    String uf, 
    String numero, 
    String complement) {
    
}
