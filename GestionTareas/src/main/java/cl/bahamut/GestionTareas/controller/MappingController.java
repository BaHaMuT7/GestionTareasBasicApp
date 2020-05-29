 package cl.bahamut.GestionTareas.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import cl.bahamut.GestionTareas.entity.Servicio;
import cl.bahamut.GestionTareas.entity.Tarea;
import cl.bahamut.GestionTareas.entity.Usuario;
import cl.bahamut.GestionTareas.service.IServicioService;
import cl.bahamut.GestionTareas.service.ITareaService;

@Controller
public class MappingController {
	
	@Autowired
	private IServicioService iRepo;
	
	@Autowired
	private ITareaService tRepo;
	
	@GetMapping(value = {"", "/"})
	public String inicio(HttpSession sesion, HttpServletRequest request) {
		sesion.setAttribute("ctx", request.getContextPath());
		return "inicio";
	}
	
	@GetMapping(value = "/servicios")
	public String servicios(Model model) {
		
		colocarServiciosModel(model);
		
		return "servicios";
	}
	
	@GetMapping(value = "/perfil")
	public String perfil() {
		return "perfil";
	}
	
	@GetMapping(value = "/tareas")
	public String tareas(HttpSession sesion, Model model) {
		
		colocarServiciosModel(model);
		
		Usuario usu = (Usuario)sesion.getAttribute("usuarioActivo");
		List<Tarea> tareas = tRepo.obtenerTareasPorUsuario(usu);
				
		sesion.setAttribute("tareasUsuario", tareas);
		
		return "tareas";
	}
	
	@GetMapping(value="/gatillarSubida")
	public String levatarSubida() {
		return "subida";
	}
	
	@GetMapping(value="/modTarea/{codigo}")
	public String modificarTarea(@PathVariable(value="codigo") String codigo, Model model) {
		
		Tarea tarea = tRepo.buscarPorCodigo(codigo);
		
		if (tarea != null) {
			model.addAttribute("tareaActiva", tarea);
			
			colocarServiciosModel(model);
			
			return "modtareas";
		} else {
			return "tareas";
		}
	}

	private void colocarServiciosModel(Model model) {
		List<Servicio> servicios = iRepo.obtenerTodos();
		model.addAttribute("servicios", servicios);
	}
	
}
