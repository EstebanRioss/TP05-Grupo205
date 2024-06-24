package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.DocenteDTO;
import ar.edu.unju.fi.model.Docente;

@Service
public interface DocenteService {
	

	public List<DocenteDTO> MostrarDocente(); 
	DocenteDTO findByLegajo(String legajo); 
	boolean save (DocenteDTO docenteDTO);
	void deleteByLegajo(String legajo);
	void edit(DocenteDTO docenteDTO);
	public Docente buscaDocente(String legajo);
	
	
}