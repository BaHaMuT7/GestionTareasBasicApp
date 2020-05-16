package cl.bahamut.GestionTareas.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cl.bahamut.GestionTareas.entity.Servicio;
import cl.bahamut.GestionTareas.service.IServicioService;

@Controller
public class MappingController {
	
	@Autowired
	private IServicioService iRepo;
	
	@Autowired
	private ApplicationContext appContext;

	
	@GetMapping(value = {"", "/"})
	public String inicio(HttpSession sesion, HttpServletRequest request) {
		sesion.setAttribute("ctx", request.getContextPath());
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
	public String tareas(HttpSession sesion, Model model) {
		
		List<Servicio> servicios = iRepo.obtenerTodos();
		model.addAttribute("servicios", servicios);
		
		return "tareas";
	}
	
	@GetMapping(value="/gatillarSubida")
	public String levatarSubida() {
		return "subida";
	}
}
