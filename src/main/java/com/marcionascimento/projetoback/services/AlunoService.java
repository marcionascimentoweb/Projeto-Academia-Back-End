package com.marcionascimento.projetoback.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.marcionascimento.projetoback.entidades.Aluno;
import com.marcionascimento.projetoback.repositories.AlunoRepository;
import com.marcionascimento.projetoback.services.exceptions.DatabaseException;
import com.marcionascimento.projetoback.services.exceptions.ResourceNotFoundException;

@Service // Registra um serviço
public class AlunoService {

	@Autowired //Injeção de dependencia
	private AlunoRepository repository;
	
	public List<Aluno> findAll(){
		return repository.findAll();
	}
	
	public Aluno findById(long id) {
		Optional<Aluno> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public Aluno insert(Aluno obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Aluno update(Long id, Aluno obj) {
		try {
			Aluno entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Aluno entity, Aluno obj) {
		entity.setNome(obj.getNome());
		entity.setDataNascimento(obj.getDataNascimento());
		entity.setSexo(obj.getSexo());
		entity.setEstadoCivil(obj.getEstadoCivil());
	}
		
}
