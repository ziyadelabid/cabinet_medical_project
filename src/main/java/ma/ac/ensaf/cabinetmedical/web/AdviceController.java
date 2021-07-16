package ma.ac.ensaf.cabinetmedical.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.ac.ensaf.cabinetmedical.entities.Advice;
import ma.ac.ensaf.cabinetmedical.services.AdviceService;

@RestController
public class AdviceController {
	@Autowired
	AdviceService adviceServ;
	@GetMapping("/advices")
	private List<Advice> listAdvices()
	{
		return adviceServ.getAllAdvice();
	}
	
}
