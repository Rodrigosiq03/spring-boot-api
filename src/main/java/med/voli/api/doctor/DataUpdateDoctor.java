package med.voli.api.doctor;

import jakarta.validation.constraints.NotNull;
import med.voli.api.address.DataAddress;

public record DataUpdateDoctor(
    @NotNull
    Long id,
    String nome,
    String cellphone,
    DataAddress address
) {}
