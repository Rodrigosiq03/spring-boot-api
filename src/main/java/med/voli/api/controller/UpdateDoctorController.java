package med.voli.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voli.api.doctor.DataUpdateDoctor;
import med.voli.api.doctor.IDoctorRepository;

@RestController
@RequestMapping("/update-doctor")
public class UpdateDoctorController {

    class ResponseTransfer {
        public String message;

        public ResponseTransfer(String message) {
            this.message = message;
        }
    }

    @Autowired
    private IDoctorRepository repo;

    @PutMapping
    @Transactional
    @ResponseBody
    public ResponseTransfer updateDoctor(@RequestBody @Valid DataUpdateDoctor data) {

        var doctor = repo.findById(data.id()).get();
        doctor.updateInfo(data);

        return new ResponseTransfer("Doctor updated successfully!");

    }
    
}
