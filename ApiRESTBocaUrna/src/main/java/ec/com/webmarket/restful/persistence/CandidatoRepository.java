package ec.com.webmarket.restful.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.com.webmarket.restful.domain.Candidato;


// Como extiende a JpaRepository Spring Data JPA generará automáticamente una implementación 
// de esta interfaz en tiempo de ejecución, proporcionando métodos como findAll(), findById(), save(), deleteById()
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {}