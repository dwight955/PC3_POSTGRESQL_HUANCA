package com.cibertec.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200")
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
		// Valor por defecto
		obj.setFlag(1);
		Map<String, Object> salida = new HashMap<>();
		Empresa objSalida = service.insertaEmpresa(obj);
		if(objSalida != null) {
			salida.put("mensaje", "Registro exitoso");
		}else {
			salida.put("mensaje", "Ocurrio un problema");
		}
		return ResponseEntity.ok(salida);
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
		Map<String, Object> salida = new HashMap<>();
		service.eliminaEmpresa(id);
		Optional<Empresa> optEmpresa = service.buscaEmpresa(id);
		if(optEmpresa.isEmpty()) {
			salida.put("mensaje", "Eliminacion exitosa");
		}else {
			salida.put("mensaje", "Ocurrio un error");
		}
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping
	public ResponseEntity<?> actualiza(@RequestBody Empresa obj) {
		Optional<Empresa> optEmpresa = service.buscaEmpresa(obj.getIdEmpresa());
		Empresa objSalida = null;
		Map<String, Object> salida = new HashMap<>();
		if (optEmpresa.isPresent()) {
			objSalida = service.insertaEmpresa(obj);
			salida.put("mensaje", "Se actualizo el ID --> "+obj.getIdEmpresa());
			return ResponseEntity.ok(salida);
		} else {
			salida.put("mensaje", "Ocurrio un error");
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/porTipoRiesgo/{id}")
	public ResponseEntity<?> consultarTipoRiesgo(@PathVariable Integer id){
		List<Empresa> listEmpresa = service.busquedaEmpresa(id);
		return ResponseEntity.ok(listEmpresa);
	}
	
}
