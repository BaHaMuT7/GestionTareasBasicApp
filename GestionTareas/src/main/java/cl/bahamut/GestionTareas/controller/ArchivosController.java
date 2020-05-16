package cl.bahamut.GestionTareas.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.bahamut.GestionTareas.entity.Imagen;
import cl.bahamut.GestionTareas.utils.Utils;

@Controller
public class ArchivosController {
	
	@Value("${gestiontareas.ruta.imagen}")
	private String ruta;
	
	@PostMapping(value="/agregarImagen")
	public String subirImagen(@RequestParam("imagen") MultipartFile multipart, RedirectAttributes atributos, HttpSession sesion) {
		
		@SuppressWarnings("unused")
		String url = "";
		
		if (!multipart.isEmpty()) {
			String nombreImagen = Utils.guardarArchivo(multipart, ruta);
			
			if (nombreImagen != null){
				url = (String)sesion.getAttribute("ctx") + "/archivosga/" + nombreImagen;
				atributos.addFlashAttribute("mensaje","successAgregarImagen");
				
				@SuppressWarnings("unchecked")
				List<Imagen> imagenes = (List<Imagen>)sesion.getAttribute("imagenes");
				
				if (imagenes == null || imagenes.size() == 0) {
					
					imagenes = new ArrayList<>();
					imagenes.add(new Imagen(url));
					
					sesion.setAttribute("imagenes", imagenes);
					
				} else {
					
					imagenes.add(new Imagen(url));
					sesion.setAttribute("imagenes", imagenes);
				}
			}
			else 
			{
				url = "error";
				atributos.addFlashAttribute("mensaje","dangerAgregarImagen");
			}
		}
		
		return "redirect:/gatillarSubida";
	}
}
