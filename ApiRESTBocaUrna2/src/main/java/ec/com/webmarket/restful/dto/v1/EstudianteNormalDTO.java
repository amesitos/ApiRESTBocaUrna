package ec.com.webmarket.restful.dto.v1;

import lombok.Data;

@Data
public class EstudianteNormalDTO {
	private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correoInstitucional;
    private String cedula;
    private String genero;
    private int edad;
    private CursoDTO curso;
    private MesaDTO mesaElectoral;
}
