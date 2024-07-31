package ec.com.webmarket.restful.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ec.com.webmarket.restful.common.ApiConstants;
import ec.com.webmarket.restful.domain.Curso;
import ec.com.webmarket.restful.persistence.CursoRepository;
import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController // Controlador de Spring MVC
@RequestMapping(ApiConstants.URI_API_V1_CURSOS) //  Define la URL base para todos los endpoints
public class CursoController {

    @Autowired //  Instancia del Repository para interactuar con restful.persistence
    private CursoRepository repository;

    @GetMapping // Mapea las solicitudes HTTP GET
    public List<Curso> getAll() { // Devuelve una lista de todos los Cursos
        return repository.findAll();
    }

    @PostMapping
    public Curso create(@RequestBody Curso curso) {
        return repository.save(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@PathVariable Long id, @RequestBody Curso cursoDetails) {
        return repository.findById(id)
                .map(curso -> {
                    curso.setNombre(cursoDetails.getNombre());
                    curso.setEstudiantes(cursoDetails.getEstudiantes());
                    curso.setCandidatos(cursoDetails.getCandidatos());
                    Curso updatedCurso = repository.save(curso);
                    return ResponseEntity.ok(updatedCurso);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
