package ec.com.webmarket.restful.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Getter
@Setter
@Entity
public class Paralelo {
	
    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParalelo;
    
    @Column(nullable = false)
    private String nombre;
    
    @ManyToOne // Muchos paralelos pueden pertenecer a un mismo curso
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @OneToMany(mappedBy = "paralelo") // Muchos estudiantes pertenecen a un paralelo
    private List<EstudianteNormal> estudiantes;
    
    @OneToMany(mappedBy = "paralelo") // Muchos candidatos pertenecen a un paralelo
    private List<Candidato> candidatos;

	
}