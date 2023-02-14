package com.jaro.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//Entidad (Tabla) Clientes en la bd

//Anotaciones para que Hibernate reconozca y persista en la bd los datos
@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//Campo autoincremental en la bd
	private Long id;
	@Column
	private String nombres;
	@Column
	private String apellidos;
	@Column
	private String direccion;
	@Column
	private String email;
	@Column
	private String telefono;
	@Temporal(TemporalType.TIMESTAMP)	//Indica que guardará la fecha y la hora
	private Date fechaRegistro;
	@Temporal(TemporalType.TIMESTAMP)	//Indica que guardará la fecha y la hora
	private Date fechaActualizacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualización(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ ", email=" + email + ", telefono=" + telefono + ", fechaRegistro=" + fechaRegistro
				+ ", fechaActualización=" + fechaActualizacion + "]";
	}

}
