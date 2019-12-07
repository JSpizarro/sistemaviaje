package pe.edu.cibertec.Viajes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.Viajes.entity.Restaurante;
@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante,Integer>{

}
