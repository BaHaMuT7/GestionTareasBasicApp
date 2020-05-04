package cl.bahamut.GestionTareas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.bahamut.GestionTareas.entity.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByNombre(String nombre);

}
