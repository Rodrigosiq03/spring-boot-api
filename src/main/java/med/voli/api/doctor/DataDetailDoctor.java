package med.voli.api.doctor;

import med.voli.api.address.Address;

public record DataDetailDoctor(Long id, String nome, String email, String crm, String telefone, Speciality especialidade, Address endereco) {
    public DataDetailDoctor (EntityDoctor doctor) {
        this(doctor.getId(), doctor.getNome(), doctor.getEmail(), doctor.getCrm(), doctor.getCellphone(), doctor.getSpeciality(), doctor.getAddress());

    }
}