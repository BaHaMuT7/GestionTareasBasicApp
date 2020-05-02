package cl.bahamut.GestionTareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.bahamut.GestionTareas.entity.Usuario;

public interface IServicioRepository extends JpaRepository<Usuario, Integer>{

}
