package cl.bahamut.GestionTareas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.bahamut.GestionTareas.entity.Servicio;
import cl.bahamut.GestionTareas.service.IServicioService;

@Controller
public class MappingController {
	
	@Autowired
	private IServicioService iRepo;
	
	@GetMapping(value = {"", "/"})
	public String inicio() {
		return "inicio";
	}
	
	@GetMapping(value = "/servicios")
	public String servicios(Model model) {
		
		List<Servicio> servicios = iRepo.obtenerTodos();
		model.addAttribute("servicios", servicios);
		
		return "servicios";
	}
	
	@GetMapping(value = "/perfil")
	public String perfil() {
		return "perfil";
	}
	
	@GetMapping(value = "/tareas")
	public String tareas() {
		return "tareas";
	}
}
