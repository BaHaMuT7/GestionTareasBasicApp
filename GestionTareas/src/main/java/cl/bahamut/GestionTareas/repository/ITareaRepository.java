package cl.bahamut.GestionTareas.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import cl.bahamut.GestionTareas.entity.Tarea;

public interface ITareaRepository extends JpaRepository<Tarea, String> {
	

}
