package cl.bahamut.GestionTareas.service;

import cl.bahamut.GestionTareas.entity.Usuario;

public interface IUsuarioService {

	public boolean guardar(Usuario usuario);
	public Usuario obtenerPorNombre(String login);
	
}
