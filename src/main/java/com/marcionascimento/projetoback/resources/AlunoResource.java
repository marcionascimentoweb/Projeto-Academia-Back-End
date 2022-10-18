package com.marcionascimento.projetoback.resources;

import java.net.URI;
import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcionascimento.projetoback.entidades.Aluno;
import com.marcionascimento.projetoback.services.AlunoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/alunos")
@Api(value="API REST Alunos")
@CrossOrigin(origins="*") //Qualquer dominio pode acessar
public class AlunoResource {
	
	@Autowired
	private AlunoService service;
	
	@GetMapping
	@ApiOperation(value="Retorna a Lista dos Alunos")
	public ResponseEntity<List<Aluno>> findAll(){
		List<Aluno> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	@ApiOperation(value="Retorna o Aluno especificado")
	public ResponseEntity<Aluno> findById(@PathVariable Long id){
		Aluno obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	@ApiOperation(value="Salva um Aluno")
	public ResponseEntity<Aluno> insert(@RequestBody Aluno obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdAluno()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	@ApiOperation(value="Deleta um Aluno")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	@ApiOperation(value="Atualiza um Aluno")
	public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno obj){
		obj = service.update(id,  obj);
		return ResponseEntity.ok().body(obj);
	}

}
