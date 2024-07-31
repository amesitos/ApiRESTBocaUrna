package ec.com.webmarket.restful.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Curso {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long idCurso;
    
    @Column(nullable = false)
    private String nombreCurso;
    
    @Column(nullable = false)
    private String paralelo;

    @OneToMany(mappedBy = "curso")
    private List<EstudianteNormal> estudiantes;

    @OneToMany(mappedBy = "curso")
    private List<Candidato> candidatos;

}