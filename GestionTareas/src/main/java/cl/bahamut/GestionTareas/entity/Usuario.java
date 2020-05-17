package cl.bahamut.GestionTareas.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String contrasenia;
	
	@OneToMany(mappedBy = "usuario")
	private List<Tarea> tareas;

	public Usuario() { }	
	
	public Usuario(Integer id) {
		this.id = id;
	}	
}
