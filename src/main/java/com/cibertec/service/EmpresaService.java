package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.entity.Empresa;

public interface EmpresaService {

	public List<Empresa> listaEmpresa();

	public Empresa insertaEmpresa(Empresa obj);

	public Optional<Empresa> buscaEmpresa(int idCategoria);

	public void eliminaEmpresa(int idCategoria);
	
	public List<Empresa> busquedaEmpresa(int idTipoRiesdo);

}
