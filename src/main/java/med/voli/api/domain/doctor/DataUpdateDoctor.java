package med.voli.api.domain.doctor;

import jakarta.validation.constraints.NotNull;
import med.voli.api.domain.address.DataAddress;

public record DataUpdateDoctor(
    @NotNull
    Long id,
    String nome,
    String cellphone,
    DataAddress address
) {}
