package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.DTO.DocenteDTO;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.service.DocenteService;


@Controller
@RequestMapping("/docente")
public class DocenteController {
	
	
	@Autowired
	@Qualifier("docenteServiceImp")
	DocenteService docenteService;
	
	@Autowired
	DocenteDTO nuevoDocenteDTO;
	@GetMapping("/formularioDocente")
	public ModelAndView getFormDocente() {
		ModelAndView modelView = new ModelAndView("formDocente");
		modelView.addObject("nuevoDocente", nuevoDocenteDTO);
		modelView.addObject("band", false);
		
		return modelView;
	}
	
	@GetMapping("/listaDeDocentes")
	public ModelAndView mostrarDocentes() {
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("ListadoDocentes", docenteService.MostrarDocente());
	
		return modelView;
	}
     
    @GetMapping("/nuevo")
    public String getVistaNuevaDocente(Model model) {
        boolean edicion = false; 
        model.addAttribute("nuevoDocente", nuevoDocenteDTO);
        model.addAttribute("edicion", edicion);
        return "formDocente";
    }
    
    
    @PostMapping("/guardar")
	public ModelAndView guardarDocente(@ModelAttribute("nuevoDocente")  DocenteDTO docenteDTO) {
		docenteService.save(docenteDTO);
		ModelAndView modelView = new ModelAndView("listaDeDocentes");
		modelView.addObject("ListadoDocentes", docenteService.MostrarDocente());
		return modelView;
	}
	

    @GetMapping("/modificar/{legajo}")
	public ModelAndView formModificarDocente(@PathVariable(name="legajo") String legajo) {
		Docente docenteModificado =  docenteService.buscaDocente(legajo);
		
		ModelAndView modelView = new ModelAndView("formDocente");
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
}