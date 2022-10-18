package com.marcionascimento.projetoback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcionascimento.projetoback.entidades.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
