package ma.ac.ensaf.cabinetmedical.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table(name="PATIENTS") 
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class PatientEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="NOM",length =25)
	private String nom;
	@Column(name="PRENOM",length =25)
	private String prenom;
	@Column(name="CIN",length=25)
	private String cin;
	@Column(nullable = false, length = 64)
    private String password;
	@Temporal(TemporalType.DATE) 
	private Date dateNaissance;
	@JsonIgnore
	@JsonManagedReference
	@OneToMany()
	@JoinColumn(name = "patient_id",referencedColumnName="id")
	private List<Appointment> appointmentList = new ArrayList<Appointment>();
}
