package ec.com.webmarket.restful.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.com.webmarket.restful.domain.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {}