package cl.bahamut.GestionTareas.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.bahamut.GestionTareas.entity.Servicio;
import cl.bahamut.GestionTareas.repository.IServicioRepository;
import cl.bahamut.GestionTareas.service.IServicioService;

@Service
public class JPAServicio implements IServicioService {

	@Autowired
	private IServicioRepository repo;
	
	@Override
	@Transactional(readOnly = true)
	public List<Servicio> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public boolean guardar(Servicio Servicio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public boolean eliminar(int idServicio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional(readOnly = true)
	public Servicio buscarPorId(int idServicio) {
		// TODO Auto-generated method stub
		return null;
	}

}
