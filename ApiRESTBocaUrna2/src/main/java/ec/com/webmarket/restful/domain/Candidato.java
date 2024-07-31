package ec.com.webmarket.restful.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Candidato extends Estudiante{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
    private Long idCandidato;

	@Column(nullable = false)
    private String lista;
	
	@Column(nullable = false)
    private String cargo;
    
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;


}