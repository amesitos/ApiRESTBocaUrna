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
import ec.com.webmarket.restful.domain.Candidato;
import ec.com.webmarket.restful.persistence.CandidatoRepository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1.0/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoRepository repository;

    @GetMapping
    public List<Candidato> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Candidato create(@RequestBody Candidato candidato) {
        return repository.save(candidato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Candidato> update(@PathVariable Long id, @RequestBody Candidato candidatoDetails) {
        return repository.findById(id)
                .map(candidato -> {
                    candidato.setNombre(candidatoDetails.getNombre());
                    candidato.setApellido(candidatoDetails.getApellido());
                    candidato.setEdad(candidatoDetails.getEdad());
                    candidato.setGenero(candidatoDetails.getGenero());
                    candidato.setLista(candidatoDetails.getLista());
                    candidato.setRol(candidatoDetails.getRol());
                    candidato.setCurso(candidatoDetails.getCurso());
                    candidato.setParalelo(candidatoDetails.getParalelo());
                    Candidato updatedCandidato = repository.save(candidato);
                    return ResponseEntity.ok(updatedCandidato);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
