package ma.ac.ensaf.cabinetmedical.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.ac.ensaf.cabinetmedical.entities.Appointment;
import ma.ac.ensaf.cabinetmedical.entities.PatientEntity;
import ma.ac.ensaf.cabinetmedical.services.PatientService;


@RestController
public class PatientController {
	@Autowired
	PatientService patientService;
	@GetMapping("/patients")
	private List<PatientEntity> listPatients()
	{
		return patientService.getAllPatientEntity();
	}
	@GetMapping("/patients/{id}")
	private PatientEntity monPatient(@PathVariable int id)
	{
		return patientService.getPatientEntityById(id);
	}
	@DeleteMapping("/delete/{id}")
	private void deletePatient(@PathVariable int id)
	{
		patientService.delete(id);
	}
	@PostMapping("/addPatient")
	private int savePatient(@RequestBody PatientEntity patient)
	{
		patientService.saveOrUpdate(patient);
		return patient.getId();
	}
	
	@PutMapping("/update")
	private PatientEntity update(@RequestBody PatientEntity patient)
	{
		patientService.saveOrUpdate(patient);
			return patient;
	}
	@GetMapping("/patients/{id}/appointments")
	private List<Appointment> listAppointments(@PathVariable int id)
	{
		return patientService.getAppointmentByPatientId(id);
	}
	
//	@PostMapping("/patients/{id}/addAppointment")
//	private int saveAppoint(@RequestBody Appointment appointment,Integer id)
//	{
//		patientService.saveAppointment(appointment, id);
//		return appointment.getId();
//	}
	
	@PutMapping("/patients/{patientId}/updateAppointment/{appointmentId}")
	private Appointment updateAppoint(@RequestBody Appointment appointment,int idPatient,int idApp)
	{
		patientService.updateAppointment(appointment,idPatient,idApp);
			return appointment;
	}
	
}
