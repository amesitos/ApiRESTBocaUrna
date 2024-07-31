package ec.com.webmarket.restful.persistence;
import org.springframework.data.jpa.repository.JpaRepository;

import ec.com.webmarket.restful.domain.EstudianteNormal;

public interface EstudianteRepository extends JpaRepository<EstudianteNormal, Long> {
	
}