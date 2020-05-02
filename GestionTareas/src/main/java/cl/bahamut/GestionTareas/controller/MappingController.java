package cl.bahamut.GestionTareas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MappingController {
	
	@GetMapping(value = {"", "/"})
	public String inicio() {
		return "inicio";
	}
	
	@GetMapping(value = "plantilla")
	public String plantilla() {
		return "plantillabs";
	}

}
