package ma.ac.ensaf.cabinetmedical.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.ac.ensaf.cabinetmedical.entities.Advice;
import ma.ac.ensaf.cabinetmedical.repositories.AdviceRep;
@Service
public class AdviceService {
	@Autowired
	AdviceRep adviceRep;
	public List <Advice> getAllAdvice()
	{
		List<Advice> advices = new ArrayList<Advice>();
		adviceRep.findAll().forEach(a->advices.add(a));
		return advices;
	}
}
