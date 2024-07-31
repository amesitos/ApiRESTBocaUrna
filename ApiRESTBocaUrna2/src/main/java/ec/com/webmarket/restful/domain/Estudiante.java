package ec.com.webmarket.restful.domain;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass

public class Estudiante {
    private String cedula;
    private String nombre;
    private String apellido;
    private String genero;
    private int edad;
    private String telefono;
    private String correoInstitucional;
    
}