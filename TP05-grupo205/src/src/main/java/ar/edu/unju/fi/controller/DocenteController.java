package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.DTO.DocenteDTO;
import ar.edu.unju.fi.service.DocenteService;


@Controller
public class DocenteController {
	
	
	@Autowired
	DocenteService docenteService;
	
	@Autowired
	DocenteDTO nuevoDocenteDTO;
	
	@GetMapping("/formularioDocente")
	public ModelAndView getFormDocente() {
		ModelAndView modelView = new ModelAndView("docente/formDocente");
		modelView.addObject("nuevoDocente",nuevoDocenteDTO);
		
		return modelView;
	}
	
	@PostMapping("/guardarDocente")
	public ModelAndView saveDocente(@ModelAttribute ("nuevoDocente") DocenteDTO DocenteDTO) {
		
		docenteService.save(DocenteDTO);
		ModelAndView modelView = new ModelAndView("docente/listadoDeDocentes");
		modelView.addObject("listadoDocentes",docenteService.MostrarDocente());
		
		return modelView;
	}
	
	@GetMapping("/borrarDocente/{legajo}")
	public ModelAndView borrarDocente(@PathVariable(name="legajo") String legajo){
		docenteService.deleteByLegajo(legajo);
		ModelAndView modelView = new ModelAndView("docente/listadoDeDocentes");
		modelView.addObject("listadoDocentes",docenteService.MostrarDocente());
		
		return modelView;
	}
	
	@GetMapping("/modificarDocente/{legajo}")
	public ModelAndView mostrarFormularioModificarAlumno(@PathVariable(name="legajo") String legajo){
		ModelAndView modelView = new ModelAndView("docente/modificacionDocente");
		modelView.addObject("Docente", docenteService.buscaDocente(legajo));

		return modelView;
	}
	
	@PostMapping("/guardarModificacionDocente")
	public ModelAndView guardarModificacionAlumno(@ModelAttribute ("Docente")DocenteDTO Docente) {
		
		docenteService.edit(Docente);
		ModelAndView modelView = new ModelAndView("docente/listadoDeDocentes");
		modelView.addObject("listadoDocentes",docenteService.MostrarDocente());
		
		return modelView;
	}
	
	/*
	@GetMapping("/formularioDocente")
	public ModelAndView getFormDocente() {
		ModelAndView modelView = new ModelAndView("docente/formDocente");
		modelView.addObject("nuevoDocente", nuevoDocenteDTO);
		modelView.addObject("band", false);
		
		return modelView;
	}
	
	@GetMapping("/listaDeDocentes")
	public ModelAndView mostrarDocentes() {
		ModelAndView modelView = new ModelAndView("docente/listaDeDocentes");
		modelView.addObject("ListadoDocentes", docenteService.MostrarDocente());
	
		return modelView;
	}
    
    
    @PostMapping("/guardarDocente")
	public ModelAndView guardarDocente(@ModelAttribute("nuevoDocente")  DocenteDTO docenteDTO) {
		docenteService.save(docenteDTO);
		ModelAndView modelView = new ModelAndView("docente/listadoDeDocentes");
		modelView.addObject("ListadoDocentes", docenteService.MostrarDocente());
		return modelView;
	}
	

    @GetMapping("/modificar/{legajo}")
	public ModelAndView formModificarDocente(@PathVariable(name="legajo") String legajo) {
		Docente docenteModificado =  docenteService.buscaDocente(legajo);
		
		ModelAndView modelView = new ModelAndView("docente/formDocente");
		modelView.addObject("nuevoDocente", docenteModificado);
		modelView.addObject("band", true);

		return modelView;
	}
    
    @PostMapping("/modificar")
	public ModelAndView modificarDocente(@ModelAttribute("docenteModificado") DocenteDTO docenteDTO) {
		docenteService.edit(docenteDTO);
		return mostrarDocentes();
	}
    
    
    @GetMapping("/borrarDocente/{legajo}")
	public ModelAndView BorrarDocente(@PathVariable(name="legajo") String legajo) {
		docenteService.deleteByLegajo(legajo);
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("ListadoDocentes", docenteService.MostrarDocente());
		return modelView;
	}
    */
}