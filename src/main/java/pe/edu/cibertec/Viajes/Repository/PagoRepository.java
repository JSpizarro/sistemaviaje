package pe.edu.cibertec.Viajes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.Viajes.entity.Pago;
@Repository
public interface PagoRepository extends JpaRepository<Pago,Integer>{

}
