package pe.edu.cibertec.Viajes.Rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.Viajes.Repository.DestinoRepository;
import pe.edu.cibertec.Viajes.entity.Destino;

@Service
public class DestinoServiceImpl implements DestinoService{
	
	@Autowired
	private DestinoRepository destinoRepository;

	@Override
	public Destino get(int id) {
		// TODO Auto-generated method stub
		return destinoRepository.findById(id).get();
	}

	@Override
	public List<Destino> getAll() {
		// TODO Auto-generated method stub
		return destinoRepository.findAll();
	}

	@Override
	public void post(Destino destino) {
		destinoRepository.save(destino);
		
	}

	@Override
	public void put(Destino destino, int id) {
		destinoRepository.findById(id).ifPresent((x)->{
			destino.setIdDestino(id);
			destinoRepository.save(destino);
			});
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		destinoRepository.deleteById(id);
		
	}

}
