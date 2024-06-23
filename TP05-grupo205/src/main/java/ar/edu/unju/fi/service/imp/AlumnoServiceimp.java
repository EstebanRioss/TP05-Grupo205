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

	@Override
	public void borrarAlumno(String codigo) {
		// TODO Auto-generated method stub
		List<Alumno> todosLosAlumnos = alumnoRepository.findAll();
		for (int i = 0 ; i < todosLosAlumnos.size();i++) {
			Alumno alumno = todosLosAlumnos.get(i);
			if(alumno.getLU().equals(codigo)) {
				alumnoRepository.delete(alumno);
			}
		}
	}

	@Override
	public void modificarAlumno(Alumno alumnoMod) {
		// TODO Auto-generated method stub
		Alumno alumnoExistente = this.buscarAlumno(alumnoMod.getLU());
		if(	alumnoExistente != null){
			alumnoExistente.setNombre(alumnoMod.getNombre());
	        alumnoExistente.setApellido(alumnoMod.getApellido());
	        alumnoExistente.setDni(alumnoMod.getDni());
	        alumnoExistente.setDomicilio(alumnoMod.getDomicilio());
	        alumnoExistente.setEmail(alumnoMod.getEmail());
	        alumnoExistente.setFechaNacimiento(alumnoMod.getFechaNacimiento());
	        alumnoExistente.setTelefono(alumnoMod.getTelefono());              
	        alumnoRepository.save(alumnoExistente);
		}
		
	}

	@Override
	public Alumno buscarAlumno(String codigo) {
		// TODO Auto-generated method stub
		List<Alumno> todosLosAlumnos = alumnoRepository.findAll();
		for (int i = 0 ; i < todosLosAlumnos.size();i++) {
			Alumno alumno = todosLosAlumnos.get(i);
			if(alumno.getLU().equals(codigo)){
				alumno.setFechaNacimiento(todosLosAlumnos.get(i).getFechaNacimiento());
				return alumno;
			}
		}
		return null;
	}
	

}
