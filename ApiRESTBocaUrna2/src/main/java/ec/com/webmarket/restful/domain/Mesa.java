package ec.com.webmarket.restful.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long idMesa;
    
    @Column(nullable = false, unique = true)
    private String nombreMesa;
    
    @Column(nullable = false)
    private String ubicacion;

    @OneToMany(mappedBy = "mesaElectoral")
    private List<EstudianteNormal> estudiantes;
    
    
}
