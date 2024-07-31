package ec.com.webmarket.restful.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.com.webmarket.restful.domain.Paralelo;

public interface ParaleloRepository extends JpaRepository<Paralelo, Long> {
	
}