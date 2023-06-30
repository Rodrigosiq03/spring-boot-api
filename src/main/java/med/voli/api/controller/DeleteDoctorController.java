package med.voli.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import med.voli.api.doctor.IDoctorRepository;

@RestController
@RequestMapping("/delete-doctor/{id}")
public class DeleteDoctorController {

    class ResponseTransfer {
        public String message;

        public ResponseTransfer(String message) {
            this.message = message;
        }
    }

    @Autowired
    private IDoctorRepository repo;

    @DeleteMapping
    @ResponseBody
    public ResponseTransfer deleteDoctor(@PathVariable("id") Long id) {

        repo.deleteById(id);

        return new ResponseTransfer("Doctor deleted successfully!");

    }
    
}
