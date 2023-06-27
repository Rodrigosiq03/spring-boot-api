package med.voli.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voli.api.doctor.DataCreationDoctor;

@RestController
@RequestMapping("/create-doctor")
public class CreateDoctorController {
    
    @PostMapping
    public void registerDoctor(@RequestBody DataCreationDoctor data) {}

}
