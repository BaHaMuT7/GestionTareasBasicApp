package cl.bahamut.GestionTareas.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tarea")
public class Tarea {
	
	private String codigo;
	
	@OneToOne
	@JoinColumn(name = "id")
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name = "id")	
	private Servicio servicio;
	
	private String descripcion;
	private String cuerpo;
	private Date fecha;
	private Date plazo;
	private Boolean cumplida;
	private String pedidaPor;
	private String ejecutadaPor;

}
