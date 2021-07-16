package ma.ac.ensaf.cabinetmedical.repositories;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.ac.ensaf.cabinetmedical.entities.Appointment;

public interface AppointmentRep extends JpaRepository<Appointment, Integer>{
	List<Appointment> findAllByPatientId(int id);
	Optional<Appointment> findByIdAndPatientId(Integer id, Integer patientId);

}
