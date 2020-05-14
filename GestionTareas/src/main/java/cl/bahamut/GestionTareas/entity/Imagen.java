package cl.bahamut.GestionTareas.entity;

import lombok.Data;

@Data
public class Imagen {

	private String url;

	public Imagen(String url) {
		this.url = url;
	}

}
