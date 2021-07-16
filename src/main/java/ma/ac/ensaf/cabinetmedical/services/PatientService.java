package ma.ac.ensaf.cabinetmedical.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.ac.ensaf.cabinetmedical.entities.Appointment;
import ma.ac.ensaf.cabinetmedical.entities.PatientEntity;
import ma.ac.ensaf.cabinetmedical.repositories.AppointmentRep;
import ma.ac.ensaf.cabinetmedical.repositories.PatientRep;

@Service
public class PatientService {
@Autowired
PatientRep patientRepository;
@Autowired
AppointmentRep appointmentRep;
//return a list of patients
public List <PatientEntity> getAllPatientEntity()
{
	List<PatientEntity> patients = new ArrayList<PatientEntity>();
	patientRepository.findAll().forEach(p->patients.add(p));
	return patients;
}
//search a patient by id
public PatientEntity getPatientEntityById(int id)
{
	return patientRepository.findById(id).get();
	}

// save a new patient
public void saveOrUpdate(PatientEntity patient)
{
	patientRepository.save(patient);
}
//delete a specific record
public void delete(int id)
{
		patientRepository.deleteById(id);
}
//update a record
public void update(PatientEntity patient, int patienId)
{
	patientRepository.save(patient);
}

public List<Appointment> getAppointmentByPatientId(int id)
{
	return appointmentRep.findAllByPatientId(id);
	}

public void saveAppointment(Appointment appointment,Integer id)
{	
	PatientEntity patient = new PatientEntity();
	appointment.setPatient(patient);
	id= patient.getId();
	appointmentRep.save(appointment);
}
public void updateAppointment(Appointment appointment,int patientId,int id)
{
	appointmentRep.save(appointment);
}
}
