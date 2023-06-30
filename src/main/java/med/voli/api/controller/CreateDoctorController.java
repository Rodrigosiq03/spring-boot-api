package med.voli.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voli.api.doctor.DataCreationDoctor;
import med.voli.api.doctor.EntityDoctor;
import med.voli.api.doctor.IDoctorRepository;


@RestController
@RequestMapping("/create-doctor")
public class CreateDoctorController {

    class ResponseTransfer {
        public String message;

        public ResponseTransfer(String message) {
            this.message = message;
        }
    }

    @Autowired
    private IDoctorRepository repo;
    
    @PostMapping
    @Transactional
    @ResponseBody
    @ResponseStatus(code = org.springframework.http.HttpStatus.CREATED)
    public ResponseTransfer registerDoctor(@RequestBody @Valid DataCreationDoctor data) {

        var doctor = new EntityDoctor(data);
        // repo.save(new EntityDoctor(data));

        

        System.out.println("DOCTOR: " + doctor);

        repo.save(doctor);

        return new ResponseTransfer("Doctor created successfully!"); 

    }

}
