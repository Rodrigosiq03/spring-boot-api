package med.voli.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voli.api.domain.doctor.IDoctorRepository;

@RestController
@RequestMapping("/delete-doctor/{id}")
public class DeleteDoctorController {

    class NoContentResponse {
        public String message = "";
    }

    @Autowired
    private IDoctorRepository repo;

    @DeleteMapping
    public ResponseEntity<NoContentResponse> deleteDoctor(@PathVariable("id") Long id) {

        repo.deleteById(id);

        return ResponseEntity.noContent().build();

    }
    
}
