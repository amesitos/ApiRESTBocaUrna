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

@Entity
@Getter
@Setter
public class EstudianteNormal extends Estudiante {
	
    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstudiante;

    @ManyToOne
    @JoinColumn(name = "mesa_id")
    private Mesa mesaElectoral;

    @ManyToOne // Muchos estudiantes pueden estar en un mismo curso
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;
    
    @ManyToOne // Muchos estudiantes pueden estar en un mismo paralelo
    @JoinColumn(name = "paralelo_id", nullable = false)
    private Paralelo paralelo;
}