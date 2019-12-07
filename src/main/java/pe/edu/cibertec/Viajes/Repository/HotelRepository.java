package pe.edu.cibertec.Viajes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.cibertec.Viajes.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer>{

}
