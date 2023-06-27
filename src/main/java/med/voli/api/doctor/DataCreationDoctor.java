package med.voli.api.doctor;

import med.voli.api.address.DataAddress;

public record DataCreationDoctor(String nome, String email, String crm, Speciality speciality, DataAddress dataAddress) {
    
}
