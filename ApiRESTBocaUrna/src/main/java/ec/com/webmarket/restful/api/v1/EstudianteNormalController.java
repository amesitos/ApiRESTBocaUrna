package ec.com.webmarket.restful.api.v1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.com.webmarket.restful.common.ApiConstants;
import ec.com.webmarket.restful.domain.EstudianteNormal;
import ec.com.webmarket.restful.persistence.EstudianteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController // Controlador de Spring MVC
@RequestMapping(ApiConstants.URI_API_V1_ESTUDIANTES) //  Define la URL base para todos los endpoints
public class EstudianteNormalController {
	
    @Autowired
    private EstudianteRepository repository;

    @GetMapping // Mapea las solicitudes HTTP GET
    public List<EstudianteNormal> getAll() { // Devuelve una lista de todos los estudiantes
        return repository.findAll();
    }

    @PostMapping
    public EstudianteNormal create(@RequestBody EstudianteNormal estudiante) {
        return repository.save(estudiante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteNormal> update(@PathVariable Long id, @RequestBody EstudianteNormal estudianteDetails) {
        return repository.findById(id)
                .map(estudiante -> {
                    estudiante.setNombre(estudianteDetails.getNombre());
                    estudiante.setApellido(estudianteDetails.getApellido());
                    estudiante.setEdad(estudianteDetails.getEdad());
                    estudiante.setGenero(estudianteDetails.getGenero());
                    estudiante.setCorreoInstitucional(estudianteDetails.getCorreoInstitucional());
                    estudiante.setCedula(estudianteDetails.getCedula());
                    estudiante.setMesaElectoral(estudianteDetails.getMesaElectoral());
                    estudiante.setCurso(estudianteDetails.getCurso());
                    estudiante.setParalelo(estudianteDetails.getParalelo());
                   
                    EstudianteNormal updatedEstudiante = repository.save(estudiante);
                    return ResponseEntity.ok(updatedEstudiante);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

