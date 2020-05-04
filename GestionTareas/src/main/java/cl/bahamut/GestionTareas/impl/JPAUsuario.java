package cl.bahamut.GestionTareas.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.bahamut.GestionTareas.entity.Usuario;
import cl.bahamut.GestionTareas.repository.IUsuarioRepository;
import cl.bahamut.GestionTareas.service.IUsuarioService;

@Service
public class JPAUsuario implements IUsuarioService {

	@Autowired
	private IUsuarioRepository repo;
	
	@Override
	@Transactional
	public boolean guardar(Usuario usuario) {
		try {
			repo.save(usuario);
			return true;
		}
		catch (Exception ex) {
			return false;
		}
	}
	
	@Override
	@Transactional(readOnly = true)	
	public Usuario obtenerPorNombre(String nombre) {
		try {
			return repo.findByNombre(nombre);	
		}
		catch (Exception ex) {
			return null;
		}			
	}

}
