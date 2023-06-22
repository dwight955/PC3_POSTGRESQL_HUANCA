package com.cibertec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Empresa;
import com.cibertec.repository.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private EmpresaRepository repository;

	@Override
	public List<Empresa> listaEmpresa() {
		return repository.findAll();
	}

	@Override
	public Empresa insertaEmpresa(Empresa obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Empresa> buscaEmpresa(int idEmpresa) {
		return repository.findById(idEmpresa);
	}

	@Override
	public void eliminaEmpresa(int idEmpresa) {
		repository.deleteById(idEmpresa);
	}

	@Override
	public List<Empresa> busquedaEmpresa(int idTipoRiesdo) {
		return repository.consultarPorTipoRiesgo(idTipoRiesdo);
	}

}
