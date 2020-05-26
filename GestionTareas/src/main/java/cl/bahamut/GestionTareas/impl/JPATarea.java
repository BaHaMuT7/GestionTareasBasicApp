package cl.bahamut.GestionTareas.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.bahamut.GestionTareas.entity.Tarea;
import cl.bahamut.GestionTareas.entity.Usuario;
import cl.bahamut.GestionTareas.repository.ITareaRepository;
import cl.bahamut.GestionTareas.service.ITareaService;

@Service
public class JPATarea implements ITareaService {
	
	@Autowired
	private ITareaRepository repo;

	@Override
	@Transactional(readOnly = true)
	public List<Tarea> obtenerTodas() {
		return repo.findAll();
	}

	@Override
	@Transactional
	public boolean guardar(Tarea tarea) {
		
		try {
			repo.save(tarea);
			return true;
		} catch (Exception ex) {
			return false;
		}
		
	}

	@Override
	@Transactional
	public boolean eliminar(String codigo) {
		try {
			repo.deleteById(codigo);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Tarea buscarPorCodigo(String codigo) {
		return repo.findById(codigo).orElse(null);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Tarea> obtenerTareasPorUsuario(Usuario usuario) {
		return repo.findByUsuario(usuario);
	}
}