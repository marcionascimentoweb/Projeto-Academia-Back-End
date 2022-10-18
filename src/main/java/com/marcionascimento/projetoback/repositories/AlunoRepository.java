package com.marcionascimento.projetoback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcionascimento.projetoback.entidades.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
