package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Alumno;

@Service
public interface AlumnoService {
	
	public void guardarAlumno(Alumno alumno);
	public List<Alumno> mostrarAlumno();
	public void borrarAlumno(String codigo);
	public void modificarAlumno(Alumno alumno);
	public Alumno buscarAlumno(String codigo);
}