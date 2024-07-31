package ec.com.webmarket.restful.dto.v1;

import lombok.Data;

@Data
public class CandidatoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String lista;
    private String cargo;
}
