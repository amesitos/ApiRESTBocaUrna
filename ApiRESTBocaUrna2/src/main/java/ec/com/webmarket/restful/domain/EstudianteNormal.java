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
public class EstudianteNormal extends Estudiante{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long idEstudianteNormal;
    
    @ManyToOne // muchos estudiantes en un curso
    @JoinColumn(name = "curso_id")
    private Curso curso;
    
    @ManyToOne // muchos estudiantes en una mesa electoral
    @JoinColumn(name = "mesa_id")
    private Mesa mesaElectoral;
}