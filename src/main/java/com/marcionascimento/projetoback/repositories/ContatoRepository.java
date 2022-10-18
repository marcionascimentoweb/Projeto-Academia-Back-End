package com.marcionascimento.projetoback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcionascimento.projetoback.entidades.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
