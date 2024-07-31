package ec.com.webmarket.restful.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ec.com.webmarket.restful.domain.Mesa;
import ec.com.webmarket.restful.persistence.MesaRepository;
import java.util.List;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/v1.0/mesas")
public class MesaController {

    @Autowired
    private MesaRepository repository;

    @GetMapping
    public List<Mesa> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Mesa create(@RequestBody Mesa mesa) {
        return repository.save(mesa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mesa> update(@PathVariable Long id, @RequestBody Mesa mesaDetails) {
        return repository.findById(id)
                .map(mesa -> {
                    mesa.setNumMesa(mesaDetails.getNumMesa());
                    mesa.setRecinto(mesaDetails.getRecinto());

                    Mesa updatedMesa = repository.save(mesa);
                    return ResponseEntity.ok(updatedMesa);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}