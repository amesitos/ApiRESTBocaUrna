package ec.com.webmarket.restful.api.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.com.webmarket.restful.domain.Paralelo;
import ec.com.webmarket.restful.persistence.ParaleloRepository;

@RestController
@RequestMapping("/api/v1.0/paralelos")
public class ParaleloController {

    @Autowired
    private ParaleloRepository repository;

    @GetMapping
    public List<Paralelo> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paralelo> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(paralelo -> ResponseEntity.ok(paralelo))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Paralelo> create(@RequestBody Paralelo paralelo) {
        Paralelo createdParalelo = repository.save(paralelo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdParalelo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paralelo> update(@PathVariable Long id, @RequestBody Paralelo paraleloDetails) {
        return repository.findById(id)
                .map(paralelo -> {
                    paralelo.setNombre(paraleloDetails.getNombre());
                    
                    Paralelo updatedParalelo = repository.save(paralelo);
                    return ResponseEntity.ok(updatedParalelo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
