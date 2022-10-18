package com.marcionascimento.projetoback.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcionascimento.projetoback.entidades.Curso;
import com.marcionascimento.projetoback.repositories.CursoRepository;

@Service // Registra um serviço
public class CursoService {

	@Autowired //Injeção de dependencia
	private CursoRepository repository;
	
	public List<Curso> findAll(){
		return repository.findAll();
	}
	
	public Curso findById(long id) {
		Optional<Curso> obj = repository.findById(id);
		return obj.get();
	}
		
}
