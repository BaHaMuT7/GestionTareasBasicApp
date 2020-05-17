package cl.bahamut.GestionTareas.service;

import java.util.List;

import cl.bahamut.GestionTareas.entity.Tarea;
import cl.bahamut.GestionTareas.entity.Usuario;

public interface ITareaService {

	public List<Tarea> obtenerTodas();
	public boolean guardar(Tarea tarea);
	public boolean eliminar(String codigo);
	public Tarea buscarPorCodigo(String codigo);
	public List<Tarea> obtenerTareasPorUsuario(Usuario usuario);
}
