package cl.bahamut.GestionTareas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.bahamut.GestionTareas.entity.Tarea;
import cl.bahamut.GestionTareas.entity.Usuario;

public interface ITareaRepository extends JpaRepository<Tarea, String> {
	
	List<Tarea> findByUsuario(Usuario usuario);

}
