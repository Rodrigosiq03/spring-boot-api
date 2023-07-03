package med.voli.api.domain.doctor;

public record DataGetAllDoctors(
    Long id,
    String nome,
    String email,
    String crm,
    Speciality speciality
) {
    public DataGetAllDoctors(EntityDoctor doctor) {
        this(doctor.getId(), doctor.getNome(), doctor.getEmail(), doctor.getCrm(), doctor.getSpeciality());
    }
}
