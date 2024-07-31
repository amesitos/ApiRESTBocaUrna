package ec.com.webmarket.restful.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ec.com.webmarket.restful.domain.Curso;
import ec.com.webmarket.restful.persistence.CursoRepository;
import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/v1.0/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @GetMapping
    public List<Curso> getAll() {
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
