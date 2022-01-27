package ma.youcode.demo22.repositories;

import ma.youcode.demo22.entities.Patien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRipository extends JpaRepository<Patien,Long> {
}
