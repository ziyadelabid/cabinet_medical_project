package ma.ac.ensaf.cabinetmedical.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="ADVICES")
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Advice {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="TITREADVICE")
	private String titre_advice;
	@Column(name="TEXTADVICE",length = 1024)
	private String text_advice;
	@Column(name="IMAGEADVICE")
	private String image_advice;
}
