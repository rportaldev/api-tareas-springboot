package com.example.demo.dto;

import java.time.LocalDate;

public class TareaDTO {

	private String titulo;
	private String descripcion;
	private LocalDate fechaVencimiento;
	
	
	public TareaDTO(String titulo, String descripcion, LocalDate fechaVencimiento) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaVencimiento = fechaVencimiento;
	}
	public TareaDTO() {
		super();
		
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	
}
