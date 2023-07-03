package med.voli.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voli.api.domain.doctor.DataDetailDoctor;
import med.voli.api.domain.doctor.IDoctorRepository;

@RestController
@RequestMapping("/get-doctor/{id}")
public class GetDoctorById {
    
    @Autowired
    private IDoctorRepository repo;

    @GetMapping
    public ResponseEntity<DataDetailDoctor> detail(@PathVariable Long id) {
        var doctor = repo.getReferenceById(id);
        return ResponseEntity.ok(new DataDetailDoctor(doctor));
    }
}
