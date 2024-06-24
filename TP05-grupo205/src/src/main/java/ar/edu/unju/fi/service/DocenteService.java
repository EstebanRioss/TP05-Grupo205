package ar.edu.unju.fi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.DTO.DocenteDTO;

@Service
public interface DocenteService {
	

	public List<DocenteDTO> MostrarDocente(); 
	public DocenteDTO findByLegajo(String legajo); 
	public void save(DocenteDTO docenteDTO);
	public void deleteByLegajo(String legajo);
	public void edit(DocenteDTO docenteDTO);
	public DocenteDTO buscaDocente(String legajo);
	
	
}