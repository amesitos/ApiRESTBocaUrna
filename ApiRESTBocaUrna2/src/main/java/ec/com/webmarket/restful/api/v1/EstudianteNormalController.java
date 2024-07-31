package ec.com.webmarket.restful.api.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.com.webmarket.restful.domain.Estudiante;
import ec.com.webmarket.restful.domain.EstudianteNormal;
import ec.com.webmarket.restful.persistence.EstudianteRepository;

@RestController
@RequestMapping("/api/v1.0/estudiantes")
public class EstudianteNormalController {
    @Autowired
    private EstudianteRepository repository;

    @GetMapping
    public List<EstudianteNormal> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public EstudianteNormal create(@RequestBody EstudianteNormal estudiante) {
        return repository.save(estudiante);
    }
}