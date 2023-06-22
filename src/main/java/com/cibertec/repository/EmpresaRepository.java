package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
	
	@Query("select x from Empresa x where x.idTipoRiesgo = ?1")
	public List<Empresa> consultarPorTipoRiesgo(int idTipoRiesgo);
}
