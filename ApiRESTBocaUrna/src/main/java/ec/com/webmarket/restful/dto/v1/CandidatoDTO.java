package ec.com.webmarket.restful.dto.v1;

import lombok.Data;

@Data
public class CandidatoDTO {
    private Long idCandidato;
    private String cedula;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String correoInstitucional;
    private String lista;
    private String cargo;
}
