package carservice.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import carservice.car.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Procedure(name="ins")
	void ins(@Param("p_PRIMERNOMBRE") String primerNombre
			     ,@Param("p_PRIMERAPELLIDO") String primerApellido
			     ,@Param("p_NUMEROIDENTIFICACION") Long numId);
}
