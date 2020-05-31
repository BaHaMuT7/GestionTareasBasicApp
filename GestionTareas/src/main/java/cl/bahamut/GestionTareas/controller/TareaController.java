package cl.bahamut.GestionTareas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.bahamut.GestionTareas.entity.Servicio;
import cl.bahamut.GestionTareas.entity.Tarea;
import cl.bahamut.GestionTareas.entity.Usuario;
import cl.bahamut.GestionTareas.service.ITareaService;
import cl.bahamut.GestionTareas.utils.Utils;


@Controller
public class TareaController {
	
	@Autowired
	private ITareaService repo;
	
	@PostMapping(value="/agregarTarea")
	public String agregarTarea(@RequestParam(value="descripcion") String descripcion,
							   @RequestParam(value="cuerpo") String cuerpo,
							   @RequestParam(value="fecha") String fecha,
							   @RequestParam(value="plazo") String plazo,
							   @RequestParam(value="servicio") int servicio,
							   @RequestParam(value="pedidaPor") String pedidaPor,
							   @RequestParam(value="sendEjecutadaPor") String ejecutadaPor,
							   HttpSession sesion, 
							   RedirectAttributes atributos) {
		
		boolean cumplida = false;			
		String codigo = Utils.R_GEN(); 
		
		Tarea tarea = new Tarea();
		
		String nuevoCuerpo = Utils.obtenerStringCorrectoCuerpo(cuerpo, (String)sesion.getAttribute("ctxFile"), (String)sesion.getAttribute("fileFolder"));
		
		tarea.setDescripcion(descripcion);
		tarea.setCuerpo(nuevoCuerpo);
		tarea.setFecha(Utils.stringToDate(fecha));
		tarea.setPlazo(Utils.stringToDate(plazo));
		tarea.setServicio(new Servicio(servicio));
		tarea.setPedidaPor(pedidaPor);
		tarea.setEjecutadaPor(ejecutadaPor);
		tarea.setCumplida(cumplida);
		tarea.setUsuario((Usuario)sesion.getAttribute("usuarioActivo"));
		tarea.setCodigo(codigo);
		
		boolean resultado = repo.guardar(tarea);
		
		if (resultado) {
			
			atributos.addFlashAttribute("mensaje", "successAgregarTarea");
			return "redirect:/tareas";
			
		} else {
			atributos.addFlashAttribute("mensaje", "dangerAgregarTarea");
			return "redirect:/tareas";			
		}		
	}
	
	
	@PostMapping(value="/modTarea")
	public String modificarTarea(@RequestParam(value="descripcion") String descripcion,
							     @RequestParam(value="cuerpo") String cuerpo,
							     @RequestParam(value="fecha") String fecha,
							     @RequestParam(value="plazo") String plazo,
							     @RequestParam(value="servicio") int servicio,
							     @RequestParam(value="pedidaPor") String pedidaPor,
							     @RequestParam(value="sendEjecutadaPor") String ejecutadaPor,
							     @RequestParam(value="codigo") String codigo,
							     @RequestParam(value="cumplida") boolean cumplida,
							     HttpSession sesion, 
							     RedirectAttributes atributos) {
			
		
		Tarea tarea = new Tarea();
		
		String nuevoCuerpo = Utils.obtenerStringCorrectoCuerpoMod(cuerpo, (String)sesion.getAttribute("ctxFile"), (String)sesion.getAttribute("fileFolder"));	
		
		tarea.setDescripcion(descripcion);
		tarea.setCodigo(codigo);
		tarea.setCuerpo(nuevoCuerpo);
		tarea.setFecha(Utils.stringToDate(fecha));
		tarea.setPlazo(Utils.stringToDate(plazo));
		tarea.setServicio(new Servicio(servicio));
		tarea.setPedidaPor(pedidaPor);
		tarea.setEjecutadaPor(ejecutadaPor);
		tarea.setCumplida(cumplida);
		tarea.setUsuario((Usuario)sesion.getAttribute("usuarioActivo"));
		tarea.setCodigo(codigo);
		
		boolean resultado = repo.guardar(tarea);
		
		if (resultado) {
			
			atributos.addFlashAttribute("mensaje", "successModificarTarea");
			return "redirect:/tareas";
			
		} else {
			atributos.addFlashAttribute("mensaje", "dangerModificarTarea");
			return "redirect:/tareas";			
		}		
	}	
	
	@GetMapping(value="/explorar/{codigoTarea}")
	public String explorarTarea(@PathVariable String codigoTarea, HttpSession sesion, RedirectAttributes atributos) {
		
		Tarea tarea = repo.buscarPorCodigo(codigoTarea);
		
		if (tarea != null) {
			sesion.setAttribute("tareaActiva", tarea);
			atributos.addFlashAttribute("modal", "cuadroTarea");
			atributos.addFlashAttribute("fActiveBody", "general");
		} else {
			atributos.addFlashAttribute("mensaje", "dangerObtenerTarea");
		}
	
		return "redirect:/tareas";
	}
	
	@GetMapping(value="/explorar/detalle/{codigoTarea}")
	public String explorarDetalleTarea(@PathVariable String codigoTarea, HttpSession sesion, RedirectAttributes atributos) {
		
		Tarea tarea = repo.buscarPorCodigo(codigoTarea);
		
		if (tarea != null) {
			sesion.setAttribute("tareaActiva", tarea);
			atributos.addFlashAttribute("modal", "cuadroTarea");
			atributos.addFlashAttribute("fActiveBody", "detalle");
		} else {
			atributos.addFlashAttribute("mensaje", "dangerObtenerTarea");
		}
	
		return "redirect:/tareas";
	}	
	
	
	@GetMapping(value="/completar/{codigoTarea}")
	public String completarTarea(@PathVariable String codigoTarea, RedirectAttributes atributos) {
		
		Tarea tarea = repo.buscarPorCodigo(codigoTarea);
		tarea.setCumplida(true);
		
		boolean resultado = repo.guardar(tarea);
		
		if (resultado) {
			atributos.addFlashAttribute("mensaje", "successCompletarTarea");			
		} else {
			atributos.addFlashAttribute("mensaje", "dangerCompletarTarea");
		}
	
		return "redirect:/tareas";
	}	
	
	@GetMapping(value="/reasignar/{codigoTarea}")
	public String reasignarTarea(@PathVariable String codigoTarea, RedirectAttributes atributos) {
		
		Tarea tarea = repo.buscarPorCodigo(codigoTarea);
		tarea.setCumplida(false);
		
		boolean resultado = repo.guardar(tarea);
		
		if (resultado) {
			atributos.addFlashAttribute("mensaje", "successReasignarTarea");			
		} else {
			atributos.addFlashAttribute("mensaje", "dangerReasignarTarea");
		}
	
		return "redirect:/tareas";
	}	

}
