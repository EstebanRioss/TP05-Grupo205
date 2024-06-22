package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.repository.AlumnoRepository;
import ar.edu.unju.fi.service.AlumnoService;

@Service
public class AlumnoServiceimp implements AlumnoService{

	
	@Autowired
	AlumnoRepository alumnoRepository;
	@Override
	public void guardarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		alumnoRepository.save(alumno);
	}

	@Override
	public List<Alumno> mostrarAlumno() {
		// TODO Auto-generated method stub
		return alumnoRepository.findAll();
	}
	

}
