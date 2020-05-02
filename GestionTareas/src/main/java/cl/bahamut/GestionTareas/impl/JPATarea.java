package cl.bahamut.GestionTareas.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.bahamut.GestionTareas.entity.Tarea;
import cl.bahamut.GestionTareas.repository.ITareaRepository;
import cl.bahamut.GestionTareas.service.ITareaService;

@Service
public class JPATarea implements ITareaService {
	
	@Autowired
	private ITareaRepository repo;

	@Override
	@Transactional(readOnly = true)
	public List<Tarea> obtenerTodas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public boolean guardar(Tarea tarea) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public boolean eliminar(String codigo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional(readOnly = true)
	public Tarea buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
