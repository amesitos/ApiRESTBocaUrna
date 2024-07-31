package ec.com.webmarket.restful.dto.v1;

import lombok.Data;

@Data
public class EstudianteNormalDTO {
    private Long idEstudiante;
    private String cedula;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String correoInstitucional;
    private CursoDTO curso;
    private ParaleloDTO paralelo;
}
