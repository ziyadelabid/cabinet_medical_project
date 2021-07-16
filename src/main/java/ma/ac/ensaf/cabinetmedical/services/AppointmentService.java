package ma.ac.ensaf.cabinetmedical.services;





import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.ac.ensaf.cabinetmedical.entities.Appointment;

import ma.ac.ensaf.cabinetmedical.repositories.AppointmentRep;



@Service
public class AppointmentService {
	@Autowired
	AppointmentRep appointmentRepo;
	
	public List <Appointment> getAllAppointment()
	{
		List<Appointment> appointments = new ArrayList<Appointment>();
		
		appointmentRepo.findAll().forEach(a->appointments.add(a));
		return appointments;
	}
}
