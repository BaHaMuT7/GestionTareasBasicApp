package cl.bahamut.GestionTareas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.bahamut.GestionTareas.entity.Usuario;
import cl.bahamut.GestionTareas.service.IUsuarioService;
import cl.bahamut.GestionTareas.utils.Utils;

@Controller
public class UsuarioController {
	
	@Autowired
	private IUsuarioService repo;
	
	@PostMapping(value = "/login")
	public String login(Usuario usuario, BindingResult result, HttpSession sesion, RedirectAttributes atributos) {
		
		usuario.setContrasenia(Utils.MD5(usuario.getContrasenia()));
		Usuario udb = repo.obtenerPorNombre(usuario.getNombre());
		
		if (udb != null) {
			
			if (usuario.getNombre().equals(udb.getNombre()) && (usuario.getContrasenia().equals(udb.getContrasenia()))) {
				
				usuario.setContrasenia(null);
				udb.setContrasenia(null);
				
				sesion.setAttribute("usuarioActivo", udb);
				
				return "/tareas";
				
			} else {
				atributos.addFlashAttribute("mensaje","Credenciales incorrectas");
				return "redirect:/";
			}
		} else {
			atributos.addFlashAttribute("mensaje","Credenciales incorrectas");
			return "redirect:/";
		}		
	}
	
	
	@PostMapping(value = "/modificarPass")
	public String modificarContrasenia(@RequestParam(value="id") int id, 
									   @RequestParam(value="password") String password,
									   @RequestParam(value="name") String nombre,
									   RedirectAttributes atributos) {
		Usuario usuario = new Usuario();
		
		usuario.setId(id);
		usuario.setContrasenia(Utils.MD5(password));
		usuario.setNombre(nombre);
			
		boolean resultado = repo.guardar(usuario);
		
		if (resultado) {
			return "redirect:/kill";	
		} else {
			atributos.addFlashAttribute("mensaje", "dangerModificarPass");
			return "redirect:/perfil";			
		}
	}
	
	@RequestMapping(value = "/kill", method = RequestMethod.GET)
	public String cerrarSesion(HttpSession sesion, RedirectAttributes atributos) {
		sesion.invalidate();
		atributos.addFlashAttribute("mensaje", "Sesión Cerrada");
		return "redirect:/";
	}
}
