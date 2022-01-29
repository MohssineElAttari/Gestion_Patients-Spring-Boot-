package ma.youcode.demo22;

import ma.youcode.demo22.entities.Patien;
import ma.youcode.demo22.repositories.PatientRipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Demo22Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Demo22Application.class, args);
    }
    @Autowired
    private PatientRipository patientRipository;
    @Override
    public void run(String... args) throws Exception {
        patientRipository.save(new Patien(null,"mohssine",new Date(),2300,false));
        patientRipository.save(new Patien(null,"othman",new Date(),1300,false));
        patientRipository.save(new Patien(null,"karim",new Date(),3300,false));
        patientRipository.save(new Patien(null,"walid",new Date(),4300,true));

        System.out.println("****************************");
        patientRipository.findAll().forEach(patien ->
                System.out.println(patien.toString())
                );
        System.out.println("****************************");
        Patien patien = patientRipository.findById(1L).get();
        System.out.println(patien.getNom());
        System.out.println("****************************");

//        List<Patien> patienList = patientRipository.findByNomContains("d");
//        patienList.forEach(patien1 -> {
//            System.out.println(patien1.toString());
//        });
//        System.out.println("****************************");

        List<Patien> patienList1 = patientRipository.findByMalade(true);
        patienList1.forEach(patien2 -> {
            System.out.println(patien2.toString());
        });
        System.out.println("****************************");
//         patientPage : get list des patients
        Page<Patien> patienPage = patientRipository.findAll(PageRequest.of(0,2));
        List<Patien> patienList2 = patienPage.getContent();
        patienList2.forEach(patien1 ->
                {
                    System.out.println(patien.toString());
                }
                );
        System.out.println("****************************");
        Page<Patien> patienPage1= patientRipository.findByNomContains("a",PageRequest.of(0,2));
        patienPage1.getContent().forEach(patien3 -> {
            System.out.println(patien3);
        });

    }
}
