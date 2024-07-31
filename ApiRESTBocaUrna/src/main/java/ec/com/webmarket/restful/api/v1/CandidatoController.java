package ec.com.webmarket.restful.api.v1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.com.webmarket.restful.common.ApiConstants;
import ec.com.webmarket.restful.domain.Candidato;
import ec.com.webmarket.restful.persistence.CandidatoRepository;
import org.springframework.web.bind.annotation.*;


@RestController // Controlador de Spring MVC
@RequestMapping(ApiConstants.URI_API_V1_CANDIDATOS) //  Define la URL base para todos los endpoints
public class CandidatoController {

    @Autowired //  Instancia del Repository para interactuar con restful.persistence
    private CandidatoRepository repository;

    // Mapeas las solicitudes GET
    @GetMapping
    public List<Candidato> getAll() { // Devuelve una lista de todos los Candidatos
        return repository.findAll(); // Almacenados en la base de datos utilizando el método findAll()
    }

    @PostMapping // Mapea las solicitudes HTTP POST
    public Candidato create(@RequestBody Candidato candidato) { // Crea un nuevo Candidato en la base de datos
        //  El @RequestBody indica que el Candidato se deserializa del cuerpo de la solicitud.
    	return repository.save(candidato); // El candidato se guarda en la base de datos usando el método save()
    }

    // ResponseEntity representa una respuesta HTTP
    @PutMapping("/{id}") // Mapea las solicitudes HTTP PUT el cual debe tener un id del candidato a actualizar
    public ResponseEntity<Candidato> update(@PathVariable Long id, @RequestBody Candidato candidatoDetails) { // Se extrae el Id y se desearliza el cuerpo de la solicitud
        return repository.findById(id)
                .map(candidato -> { // Si el candidato es encontrado, se actualizan sus detalles con los proporcionados en candidatoDetails
                    candidato.setNombre(candidatoDetails.getNombre());
                    candidato.setApellido(candidatoDetails.getApellido());
                    candidato.setEdad(candidatoDetails.getEdad());
                    candidato.setGenero(candidatoDetails.getGenero());
                    candidato.setLista(candidatoDetails.getLista());
                    candidato.setRol(candidatoDetails.getRol());
                    candidato.setCurso(candidatoDetails.getCurso());
                    candidato.setParalelo(candidatoDetails.getParalelo());
                    Candidato updatedCandidato = repository.save(candidato); // Se guarda la info nueva del candidato
                    return ResponseEntity.ok(updatedCandidato); //  retorna un ResponseEntity con el candidato actualizado y un código de respuesta HTTP 200 (OK).
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
