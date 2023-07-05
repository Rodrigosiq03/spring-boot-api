package med.voli.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voli.api.domain.doctor.DataCreationDoctor;
import med.voli.api.domain.doctor.DataDetailDoctor;
import med.voli.api.domain.doctor.EntityDoctor;
import med.voli.api.domain.doctor.IDoctorRepository;


@RestController
@RequestMapping("/create-doctor")
public class CreateDoctorController {

    @Autowired
    private IDoctorRepository repo;
    
    @PostMapping
    @Transactional
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<DataDetailDoctor> registerDoctor(@RequestBody @Valid DataCreationDoctor data, UriComponentsBuilder uriBuilder) {

        var doctor = new EntityDoctor(data);

        repo.save(doctor);

        var uri = uriBuilder.path("/get-doctor/{id}").buildAndExpand(doctor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataDetailDoctor(doctor));

    }

}
