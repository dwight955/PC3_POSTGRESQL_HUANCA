package com.cibertec.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "empresa")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEmpresa")
	private int idEmpresa;

	@Column(length = 255, name = "contacto")
	private String contacto;
	
	@Column(nullable = false, length = 255, name = "email")
	private String email;
	
	@Column(nullable = false, name = "flag")
	private int flag;

	@Column(length = 255, nullable = false, name = "razonSocial")
	private String razonSocial;
	
	@Column(length = 11, nullable = false, name = "ruc")
	private String ruc;
	
	@Column(nullable = false, name = "idTipoRiesgo")
	private int idTipoRiesgo;
}
