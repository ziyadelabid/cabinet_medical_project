package ma.ac.ensaf.cabinetmedical.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.ac.ensaf.cabinetmedical.entities.Appointment;
import ma.ac.ensaf.cabinetmedical.repositories.AppointmentRep;
import ma.ac.ensaf.cabinetmedical.repositories.PatientRep;
import ma.ac.ensaf.cabinetmedical.services.AppointmentService;

@RestController
public class AppointmentController {
	
	@Autowired
	private PatientRep patientRepo;
	@Autowired
	private AppointmentRep appRep;
	@Autowired
	private AppointmentService appServ;
	@GetMapping("/listappointments")
	private List<Appointment> listAppointments()
	{
		return appServ.getAllAppointment();
	}
	@PostMapping("/patients/{patientId}/addAppointment")
    public Optional<Appointment> createAppointment(@PathVariable (value = "patientId") Integer patientId,
                                  @RequestBody Appointment appointment) {
        return patientRepo.findById(patientId).map(patient -> {
            appointment.setPatient(patient);
            return appRep.save(appointment);
        });
    }
}
