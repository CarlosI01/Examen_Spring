package com.ista.springtboot.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "empleado")
public class Empleado implements Serializable{
	
	//private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id_empleado")
	private Integer id_empleado;

	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "apellido")
	private String apellido;
	
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "nombre")
	private String nombre;
	
	@NotNull
	@Size(min = 1, max = 15)
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "direccion")
	private String direccion;

	@Column(name = "fecha_nacimiento")
	private Date fecha_nacimiento;
	
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "observacion")
	private String observacion;
	
	@Column(name = "dias_trabajo")
	private Integer dias_trabajo;
	
	@Column(name = "sueldo")
	private Double sueldo;
	
}
