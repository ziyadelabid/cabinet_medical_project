package ma.ac.ensaf.cabinetmedical.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ac.ensaf.cabinetmedical.entities.Advice;

public interface AdviceRep extends JpaRepository<Advice, Integer> {
	
}
