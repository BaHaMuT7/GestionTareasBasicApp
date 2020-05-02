package cl.bahamut.GestionTareas.service;

import java.util.List;

import cl.bahamut.GestionTareas.entity.Servicio;

public interface IServicioService {

	public List<Servicio> obtenerTodos();
	public boolean guardar(Servicio Servicio);
	public boolean eliminar(int idServicio);
	public Servicio buscarPorId(int idServicio);
	
}
