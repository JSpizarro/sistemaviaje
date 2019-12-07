package pe.edu.cibertec.Viajes.Rest;

import java.util.List;

import pe.edu.cibertec.Viajes.entity.Destino;

public interface DestinoService {
	public Destino get(int id);
	public List<Destino> getAll();
	public void post(Destino destino);
	public void put(Destino destino,int id);
	public void delete(int id);
}
