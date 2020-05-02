package cl.bahamut.GestionTareas.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Tarea {
	
	private String codigo;
	private Usuario usuario;
	private Servicio servicio;
	private String descripcion;
	private String cuerpo;
	private Date fecha;
	private Date plazo;
	private Boolean cumplida;
	private String pedidaPor;
	private String ejecutadaPor;

}
