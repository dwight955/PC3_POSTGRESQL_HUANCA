package com.cibertec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Empresa;
import com.cibertec.service.EmpresaService;

@RestController
@RequestMapping("/rest/Empresa")
public class EmpresaController {

	@Autowired
	private EmpresaService service;

	@GetMapping()
	public ResponseEntity<?> lista() {
		List<Empresa> lstSalida = service.listaEmpresa();
		return ResponseEntity.ok(lstSalida);
	}

	@PostMapping
	public ResponseEntity<?> inserta(@RequestBody Empresa obj) {
		Empresa objSalida = service.insertaEmpresa(obj);
		return ResponseEntity.ok(objSalida);
	}

	@GetMapping("/porId/{id}")
	public ResponseEntity<?> listaPorIdEnPath(@PathVariable Integer id) {
		Optional<Empresa> optSalida = service.buscaEmpresa(id);
		return ResponseEntity.ok(optSalida.get());
	}
 
	
	@GetMapping("/porId")
	public ResponseEntity<?> listaPorIdEnParamaterer(
			@RequestParam(name = "id", defaultValue = "0", required = true) Integer id) {
		Optional<Empresa> optSalida = service.buscaEmpresa(id);
		return ResponseEntity.ok(optSalida.get());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminaEmpresa(@PathVariable Integer id) {
		service.eliminaEmpresa(id);
		Optional<Empresa> optEmpresa = service.buscaEmpresa(id);
		if (optEmpresa.isEmpty()) {
			return ResponseEntity.ok("Eliminación exitosa");
		}
		return ResponseEntity.ok("No existe el id " + id);
	}
	
	@PutMapping
	public ResponseEntity<?> actualiza(@RequestBody Empresa obj) {
		Optional<Empresa> optEmpresa = service.buscaEmpresa(obj.getIdEmpresa());
		if (optEmpresa.isPresent()) {
			Empresa objSalida = service.insertaEmpresa(obj);
			return ResponseEntity.ok(objSalida);
		} else {
			return ResponseEntity.ok("El Empresa no existe");
		}
	}
	
	@GetMapping("/porTipoRiesgo/{id}")
	public ResponseEntity<?> consultarTipoRiesgo(@PathVariable Integer id){
		List<Empresa> listEmpresa = service.busquedaEmpresa(id);
		return ResponseEntity.ok(listEmpresa);
	}
	
}
