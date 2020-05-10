package cl.bahamut.GestionTareas.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.bahamut.GestionTareas.utils.Utils;

@Controller
public class ArchivosController {
	
	@Value("${gestiontareas.ruta.imagen}")
	private String ruta;
	

	@PostMapping(value="/agregarImagen")
	public String subirImagen(@RequestParam("imagen") MultipartFile multipart) {
		String url = "";
		
		if (!multipart.isEmpty()) {
			String nombreImagen = Utils.guardarArchivo(multipart, ruta);
			
			if (nombreImagen != null){
				url = "img/" + nombreImagen;
			}
			else 
			{
				url = "error";
			}
		}
		
		return "redirect:/tareas";
	}
	
	
	@GetMapping(value="/gatillarSubida")
	public String levatarSubida(RedirectAttributes atributos) {
		return "redirect:/subida";
	}

}
