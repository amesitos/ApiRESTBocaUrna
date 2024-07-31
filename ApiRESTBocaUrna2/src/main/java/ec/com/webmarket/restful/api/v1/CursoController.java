package ec.com.webmarket.restful.api.v1;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import ec.com.webmarket.restful.domain.Curso;
import ec.com.webmarket.restful.persistence.CursoRepository;

import java.util.List;

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
}