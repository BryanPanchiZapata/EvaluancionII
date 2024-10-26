package com.krakedev.moduloii.evaluacionfinal.entidades;

public class Grupo {
	private String idGrupo;
	private String nombre;
	
	public Grupo() {
		
	}
	public Grupo(String idGrupo, String nombre) {
		super();
		this.idGrupo = idGrupo;
		this.nombre = nombre;
	}
	public String getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(String idGrupo) {
		this.idGrupo = idGrupo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Grupo [idGrupo=" + idGrupo + ", nombre=" + nombre + "]";
	}
	
	
	
}
