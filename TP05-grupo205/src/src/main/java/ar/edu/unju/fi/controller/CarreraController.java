package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.DTO.CarreraDTO;
import ar.edu.unju.fi.service.CarreraService;

@Controller
public class CarreraController {
    
	@Autowired
	private CarreraDTO nuevacarreraDTO;
	
    @Autowired
    private CarreraService cs;
    
    
    @GetMapping("/formularioCarrera")
	public ModelAndView getFormCarrera() {
    	
		ModelAndView modelView = new ModelAndView("formCarrera");
		modelView.addObject("nuevaCarrera",nuevacarreraDTO);
		
		return modelView;
	}
    
    @PostMapping("/guardarCarrera")
    public ModelAndView saveCarrera(@ModelAttribute("nuevaCarrera") CarreraDTO carrera) {
        cs.guardarCarrera(carrera);
        ModelAndView modelView = new ModelAndView("listaDeCarreras");
        modelView.addObject("listadoCarreras", cs.MostrarCarrera()); 
        return modelView;
    }
    
    @GetMapping("/borrarCarrera/{codigo}")
	public ModelAndView borrarCarrera(@PathVariable(name="codigo") String codigo){
		cs.borrarCarrera(codigo);
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarreras",cs.MostrarCarrera());
		
		return modelView;
	}
    @GetMapping("/DarDeAlta/{codigo}")
	public ModelAndView DarDeAlta(@PathVariable(name="codigo") String codigo){
		cs.darDeAltaCarrera(codigo);
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarreras",cs.MostrarCarrera());
		
		return modelView;
	}
    
    @GetMapping("/modificarCarrera/{codigo}")
	public ModelAndView mostrarFormularioModificarCarrera(@PathVariable("codigo") String codigo){
		
		ModelAndView modelView = new ModelAndView("modificacionCarrera");
		modelView.addObject("carrera", cs.buscaCarrera(codigo));

		return modelView;
	}
    
    @PostMapping("/guardarModificacionCarrera")
	public ModelAndView guardarModificacionCarrera(@ModelAttribute ("carrera") CarreraDTO carrera) {
		
		cs.modificarCarrera(carrera);
		ModelAndView modelView = new ModelAndView("listaDeCarreras");
		modelView.addObject("listadoCarreras",cs.MostrarCarrera());
		
		return modelView;
	}
    
    /*
    // Muestra Carreras
    @GetMapping("/listado")
    public String getCarreras(Model model) {
       model.addAttribute("carrera/formCarrera", cs.MostrarCarrera());
        return "listaDeCarreras";
    }
    
    @GetMapping("/nuevo")
    public String getVistaNuevaCarrera(Model model) {
        boolean edicion = false; // No quiero editar un objeto
        model.addAttribute("nuevaCarrera", nuevaCarrera);
        model.addAttribute("edicion", edicion);
        return "formCarrera";
    }
    
    @PostMapping("/guardar")
    public String guardarCarrera(@ModelAttribute("nuevaCarrera") Carrera carrera) {
        cs.guardarCarrera(carrera);
        //System.out.println("Carrera en el metodo Guardar" + carrera.getCodigo());
        return "redirect:/carrera/listado";
    }
    
    @GetMapping("/modificarCarrera/{codigo}")
    public String getModificarCarreraPague(Model model, @PathVariable(value = "codigo") String codigo) {
        Carrera nuevaCarrera = cs.buscaCarrera(codigo);
        boolean edicion = true;
        model.addAttribute("nuevaCarrera", nuevaCarrera);
        model.addAttribute("edicion", edicion);
        return "formCarrera";
    }
    
    @PostMapping("/modificar")
    public String modificarCarrera(@ModelAttribute("nuevaCarrera") Carrera carrera) {
       cs.modificarCarrera(carrera);
        return "redirect:/carrera/listado";
    }
    
    @GetMapping("/borrarCarrera/{codigo}")
    public String eliminarCarrera(@PathVariable(value = "codigo") String codigo) {
    	cs.borrarCarrera(codigo);
    	return "redirect:/carrera/listado";
    }
    */
    
}