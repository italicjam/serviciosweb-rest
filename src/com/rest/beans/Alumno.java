package com.rest.beans;

import java.io.Serializable;
import java.util.Date;

public class Alumno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String apePat;
	private String apeMat;
	private Date fecNac;
	
	public Alumno(int id, String nombre, String apePat, String apeMat,
			Date fecNac) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apePat = apePat;
		this.apeMat = apeMat;
		this.fecNac = fecNac;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApePat() {
		return apePat;
	}

	public void setApePat(String apePat) {
		this.apePat = apePat;
	}

	public String getApeMat() {
		return apeMat;
	}

	public void setApeMat(String apeMat) {
		this.apeMat = apeMat;
	}

	public Date getFecNac() {
		return fecNac;
	}

	public void setFecNac(Date fecNac) {
		this.fecNac = fecNac;
	}
	
}
