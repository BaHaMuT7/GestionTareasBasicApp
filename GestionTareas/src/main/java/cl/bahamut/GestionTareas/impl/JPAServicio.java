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
		try {
			return repo.findAll();
		}
		catch (Exception ex) {
			return null;
		}
	}

	@Override
	@Transactional
	public boolean guardar(Servicio servicio) {
		try {
			repo.save(servicio);
			return true;
		}
		catch (Exception ex) {
			return false;
		}
	}

	@Override
	@Transactional
	public boolean eliminar(int idServicio) {
		try {
			repo.deleteById(idServicio);
			return true;
		}
		catch (Exception ex) {
			return false;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Servicio buscarPorId(int idServicio) {
		try {
			return repo.findById(idServicio).orElse(null);
		}
		catch (Exception ex) {
			return null;
		}
	}

}
