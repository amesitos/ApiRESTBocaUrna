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
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;
    
    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "curso") // Un curso para muchos estudiantes normales 
    private List<EstudianteNormal> estudiantes;

    @OneToMany(mappedBy = "curso") // Un curso para muchos candidatos
    private List<Candidato> candidatos;


}