package med.voli.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voli.api.domain.doctor.DataGetAllDoctors;
import med.voli.api.domain.doctor.IDoctorRepository;

@RestController
@RequestMapping("/get-all-doctors")
public class GetAllDoctors {
    
    @Autowired
    private IDoctorRepository repo;

    @GetMapping
    public ResponseEntity<Page<DataGetAllDoctors>> getAllDoctors(@PageableDefault(size = 10, sort = {"nome"}) Pageable pagenation) {
        // return all doctors
        // var doctors = repo.findAll().stream().map(DataGetAllDoctors::new).toList();

        var doctors = repo.findAll(pagenation).map(DataGetAllDoctors::new);

        return ResponseEntity.ok(doctors);
        
    }
}
