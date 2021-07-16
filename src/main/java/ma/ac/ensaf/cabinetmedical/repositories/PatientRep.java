package ma.ac.ensaf.cabinetmedical.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ac.ensaf.cabinetmedical.entities.PatientEntity;


public interface PatientRep extends JpaRepository<PatientEntity,Integer> {
	public List<PatientEntity> findByNomContains(String name);

}
