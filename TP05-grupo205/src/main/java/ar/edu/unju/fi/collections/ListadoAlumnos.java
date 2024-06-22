package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ar.edu.unju.fi.model.Alumno;


public class ListadoAlumnos {
	public static List<Alumno> Alumnos = new ArrayList<Alumno>();
	
	public static List<Alumno> listarAlumnos(){
		return Alumnos;
	}
	
	public static Alumno buscarAlumnoPorCodigo(String codigo){
		for(Alumno c : Alumnos) {
			if(c.getLU().equals(codigo)){
				return c;
			}
		}
		return null;
	}
	
	public static void agregarAlumno(Alumno c) {
		Alumnos.add(c);
	}
	
	public static void modificarAlumno(Alumno AlumnoModificada) {
		for(int i = 0 ; i < Alumnos.size() ; i++) {
			Alumno alumno = Alumnos.get(i);
			if(alumno.getLU().equals(AlumnoModificada.getLU())) {
				Alumnos.set(i,AlumnoModificada);
				break;
			}
		}
	}
	
	public static void eliminarAlumno(String codigo) {
		Iterator<Alumno> iterator = Alumnos.iterator();
	    while (iterator.hasNext()) {
	        Alumno c = iterator.next();
	        if (c.getLU().equals(codigo)) {
	            iterator.remove();
	            break;
	        }
	    }
	}
	
}
