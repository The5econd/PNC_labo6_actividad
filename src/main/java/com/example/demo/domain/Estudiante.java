package com.example.demo.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(schema="public", name="estudiante")
public class Estudiante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_estudiante")
	private Integer codigoEstudiante;
	
	@Column(name="nombre")
	@NotEmpty(message="No puede ser vacio")
	@Size(max = 20, message = "No mas de 30 caracteres")
	private String nombre;
	
	@Column(name="apellido")
	@NotEmpty(message="No puede ser vacio")
	@Size(max = 20, message = "no mas de 30 caracteres")
	private String apellido;
	
	@Column(name="edad")
	@NotNull(message = "No puede ser vacio")
	@Min(value = 18, message = "No menor de 18 anios")
	private Integer edad;
	
	@Column(name="estado")
	private Boolean estado;
	
	public Estudiante(){}

	public String getEstadoDelegate() {
		if(this.estado == null) return "";
		else {
			return estado == true ?"Activo":"Inactivo";
		}
	}
	
	public Integer getCodigoEstudiante() {
		return codigoEstudiante;
	}


	public void setCodigoEstudiante(Integer codigoEstudiante) {
		this.codigoEstudiante = codigoEstudiante;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Integer getEdad() {
		return edad;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
}