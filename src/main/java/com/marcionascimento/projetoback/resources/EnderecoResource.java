package com.marcionascimento.projetoback.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcionascimento.projetoback.entidades.Aluno;
import com.marcionascimento.projetoback.entidades.Endereco;
import com.marcionascimento.projetoback.services.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {
	
	@Autowired
	private EnderecoService service;
	
	@GetMapping
	public ResponseEntity<List<Endereco>> findAll(){
		List<Endereco> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Endereco> findById(@PathVariable Long id){
		Endereco obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
