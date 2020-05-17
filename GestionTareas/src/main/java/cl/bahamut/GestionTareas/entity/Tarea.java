package cl.bahamut.GestionTareas.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tarea")
public class Tarea {
	
	@Id
	private String codigo;
	
	@OneToOne
	@JoinColumn(name = "usuario")
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name = "servicio")	
	private Servicio servicio;
	
	private String descripcion;
	private String cuerpo;
	private Date fecha;
	private Date plazo;
	private Boolean cumplida;
	
	@Column(name = "pedidapor")
	private String pedidaPor;
	
	@Column(name = "ejecutadapor")
	private String ejecutadaPor;

}
