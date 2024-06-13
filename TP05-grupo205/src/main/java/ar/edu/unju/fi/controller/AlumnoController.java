package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.Collections.ListadoAlumnos;
import ar.edu.unju.fi.model.Alumno;

public class AlumnoController {
	@Autowired
	Alumno nuevoAlumno = new Alumno();
	
	@GetMapping("/formularioAlumno")
	public ModelAndView getFormAlumno() {
		ModelAndView modelView = new ModelAndView("alumno/formAlumno");
		modelView.addObject("nuevoAlumno",nuevoAlumno);
		
		return modelView;
	}
	@PostMapping("/guardarAlumno")
	public ModelAndView saveAlumno(@ModelAttribute ("nuevoAlumno") Alumno Alumno) {
		
		ListadoAlumnos.agregarAlumno(Alumno);
		ModelAndView modelView = new ModelAndView("Alumno/listaDeAlumnos");
		modelView.addObject("listadoAlumnos",ListadoAlumnos.listarAlumnos());
		
		return modelView;
	}
	@GetMapping("/borrarAlumno/{LU}")
	public ModelAndView borrarAlumno(@PathVariable(name="LU") String LU){
		ListadoAlumnos.eliminarAlumno(LU);
		ModelAndView modelView = new ModelAndView("/Alumno/listaDeAlumnos");
		modelView.addObject("listadoAlumnos",ListadoAlumnos.listarAlumnos());
		
		return modelView;
	}
	
	@GetMapping("/modificarAlumno/{LU}")
	public ModelAndView mostrarFormularioModificarAlumno(@PathVariable(name="LU") String LU){
		nuevoAlumno = ListadoAlumnos.buscarAlumnoPorCodigo(LU);
		ModelAndView modelView = new ModelAndView("/Alumno/modificacionAlumno");
		modelView.addObject("Alumno", nuevoAlumno);

		return modelView;
	}
	
	@PostMapping("/guardarModificacionAlumno")
	public ModelAndView guardarModificacionAlumno(@ModelAttribute ("Alumno") Alumno Alumno) {
		
		ListadoAlumnos.modificarAlumno(Alumno);
		ModelAndView modelView = new ModelAndView("/Alumno/listaDeAlumnos");
		modelView.addObject("listadoAlumnos",ListadoAlumnos.listarAlumnos());
		
		return modelView;
	}
	
}
