package pe.edu.cibertec.Viajes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.Viajes.entity.Paquetesviaje;

@Repository
public interface PaquetesviajeRepository extends JpaRepository<Paquetesviaje, Integer> {
	
	

}
