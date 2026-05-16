package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TareaDTO;
import com.example.demo.model.Tarea;
import com.example.demo.repository.TareaRepository;

@Service
public class TareaService {

	@Autowired
	private TareaRepository tareaRepository;
	
	
	//CREAR
	public Tarea crearTarea(TareaDTO dto) {
		
		Tarea tarea = new Tarea();
		
		tarea.setTitulo(dto.getTitulo());
		tarea.setDescripcion(dto.getDescripcion());
		tarea.setFechaVencimiento(dto.getFechaVencimiento());
		tarea.setEstado("Pendiente");
		tarea.setFechaCreacion(LocalDate.now());
		
		return tareaRepository.save(tarea);
	}
	
	
	//LISTAR
	public List<Tarea> listarTareas(){
		return tareaRepository.findAll();
	}
	
	
	//OBTENER POR ID
	public Tarea obtenerTareaPorId(Long id) {
	    return tareaRepository.findById(id).orElse(null);
	}
	
	
	//ACTUALIZAR
	public Tarea actualizarTarea(Long id, String titulo, String descripcion, String estado,
									 LocalDate fechaVencimiento ) {
		
		Tarea tarea = tareaRepository.findById(id).orElse(null);
		
		if(tarea != null) {
			tarea.setTitulo(titulo);
			tarea.setDescripcion(descripcion);
			tarea.setEstado(estado);
			tarea.setFechaVencimiento(fechaVencimiento);
			return tareaRepository.save(tarea);
		}
		
		return null;
	}
	
	
	//ELIMINAR
	public boolean eliminarTarea(Long id) {
		
		if (tareaRepository.existsById(id)) {
			tareaRepository.deleteById(id);
			return true;
        }
		
		return false;
	}
	
	
	//MARCAR COMO COMPLETADA
	public Tarea marcarComoCompletada(Long id) {
		
		Tarea tarea = tareaRepository.findById(id).orElse(null);
		
		if(tarea != null) {
			tarea.setEstado("Completada");
			return tareaRepository.save(tarea);
		}
		
		return null;
	}
	
	
	//LISTAR POR ESTADOS
	public List<Tarea> listarPorEstado(String estado){
		return tareaRepository.findByEstado(estado);
	}

}
