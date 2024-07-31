package ec.com.webmarket.restful.domain;


import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


@MappedSuperclass
@Getter
@Setter

public class Estudiante {
    private String cedula;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String correoInstitucional;
}

