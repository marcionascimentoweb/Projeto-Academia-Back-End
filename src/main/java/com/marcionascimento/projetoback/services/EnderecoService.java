package com.marcionascimento.projetoback.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcionascimento.projetoback.entidades.Endereco;
import com.marcionascimento.projetoback.repositories.EnderecoRepository;

@Service // Registra um serviço
public class EnderecoService {

	@Autowired //Injeção de dependencia
	private EnderecoRepository repository;
	
	public List<Endereco> findAll(){
		return repository.findAll();
	}
	
	public Endereco findById(long id) {
		Optional<Endereco> obj = repository.findById(id);
		return obj.get();
	}
		
}
