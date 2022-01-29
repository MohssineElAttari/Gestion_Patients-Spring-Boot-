package ma.youcode.demo22.Controller;

import ma.youcode.demo22.entities.Patien;
import ma.youcode.demo22.repositories.PatientRipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientRipository patientRipository;

    @GetMapping("/patients")
    public List<Patien> patiens(){
        return patientRipository.findAll();
    }

    @GetMapping("/patient/{id}")
    public Patien getPatien(@PathVariable Long id){
        return patientRipository.findById(id).get();
    }
}
