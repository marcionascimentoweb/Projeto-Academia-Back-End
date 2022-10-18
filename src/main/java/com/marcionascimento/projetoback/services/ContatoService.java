package com.marcionascimento.projetoback.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcionascimento.projetoback.entidades.Contato;
import com.marcionascimento.projetoback.entidades.Endereco;
import com.marcionascimento.projetoback.repositories.ContatoRepository;

@Service // Registra um serviço
public class ContatoService {

	@Autowired //Injeção de dependencia
	private ContatoRepository repository;
	
	public List<Contato> findAll(){
		return repository.findAll();
	}
	
	public Contato findById(long id) {
		Optional<Contato> obj = repository.findById(id);
		return obj.get();
	}
		
}
