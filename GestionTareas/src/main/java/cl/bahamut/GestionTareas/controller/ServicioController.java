package cl.bahamut.GestionTareas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.bahamut.GestionTareas.entity.Servicio;
import cl.bahamut.GestionTareas.service.IServicioService;

@Controller
public class ServicioController {

	@Autowired
	private IServicioService repo;

	@PostMapping(value = "/agregarServicio")
	public String agregarServicio(Servicio servicio, BindingResult result, RedirectAttributes atributos) {

		boolean resultado = repo.guardar(servicio);

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage());
		}

		if (resultado) {
			atributos.addFlashAttribute("mensaje", "successAgregarServicio");
			atributos.addFlashAttribute("servicios", repo.obtenerTodos());
			return "redirect:/servicios";
		} else {
			atributos.addFlashAttribute("mensaje", "dangerAgregarServicio");
			atributos.addFlashAttribute("servicios", repo.obtenerTodos());
			return "redirect:/servicios";
		}
	}
	
	@GetMapping(value = "/eliminarServicio/{id}")
	public String eliminarServicio(@PathVariable("id") int idServicio, RedirectAttributes atributos) {
		
		boolean resultado = repo.eliminar(idServicio);
		
		if (resultado) {
			atributos.addFlashAttribute("mensaje", "successEliminarServicio");
			atributos.addFlashAttribute("servicios", repo.obtenerTodos());
			return "redirect:/servicios";			
		} else {
			atributos.addFlashAttribute("mensaje", "dangerEliminarServicio");
			atributos.addFlashAttribute("servicios", repo.obtenerTodos());
			return "redirect:/servicios";			
		}		
	}

	@GetMapping(value = "/gatillarModificacionServicio/{id}")
	public String gatillarModificacionServicio(@PathVariable("id") int idServicio, RedirectAttributes atributos) {
		
		Servicio servicio = repo.buscarPorId(idServicio);
		
		if (servicio != null) {
			
			atributos.addFlashAttribute("servicioActivo", servicio);
			atributos.addFlashAttribute("modal", "modalModificarServicio");
			
			return "redirect:/servicios";
			
		} else {
			
			atributos.addFlashAttribute("mensaje", "dangerGmodServicio");
			atributos.addFlashAttribute("servicios", repo.obtenerTodos());
			
			return "redirect:/servicios";			
		}		
	}
	
	
	@PostMapping(value="/modificarServicio")
	public String modificarServicio(Servicio servicio, BindingResult result, RedirectAttributes atributos) {
		
		boolean resultado = repo.guardar(servicio);
		
		if (resultado) {
			atributos.addFlashAttribute("mensaje", "successModificarServicio");
			atributos.addFlashAttribute("servicios", repo.obtenerTodos());
			return "redirect:/servicios";				
		} else {
			atributos.addFlashAttribute("mensaje", "dangerModificarServicio");
			atributos.addFlashAttribute("servicios", repo.obtenerTodos());
			return "redirect:/servicios";				
		}
	}
}
