package med.voli.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voli.api.domain.doctor.DataDetailDoctor;
import med.voli.api.domain.doctor.DataUpdateDoctor;
import med.voli.api.domain.doctor.IDoctorRepository;

@RestController
@RequestMapping("/update-doctor/{id}")
public class UpdateDoctorController {

    @Autowired
    private IDoctorRepository repo;

    @PutMapping
    @Transactional
    @ResponseBody
    public ResponseEntity<DataDetailDoctor> updateDoctor(@PathVariable long id, @RequestBody @Valid DataUpdateDoctor data) {
        var doctor = repo.getReferenceById(id);
        doctor.updateInfo(data);

        return ResponseEntity.ok(new DataDetailDoctor(doctor));

    }
    
}
