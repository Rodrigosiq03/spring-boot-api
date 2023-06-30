package med.voli.api.doctor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctorRepository extends JpaRepository<EntityDoctor, Long> {}
