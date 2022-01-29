package ma.youcode.demo22.repositories;

import ma.youcode.demo22.entities.Patien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRipository extends JpaRepository<Patien,Long> {
//    public List<Patien> findByNomContains(String name);
    public Page<Patien> findByNomContains(String name, Pageable pageable);
    public List<Patien> findByMalade(boolean malade);
}
