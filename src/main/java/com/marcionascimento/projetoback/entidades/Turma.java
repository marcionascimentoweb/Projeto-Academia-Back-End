package com.marcionascimento.projetoback.entidades;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marcionascimento.projetoback.entidades.pk.TurmaPK;

@Entity
@Table(name  = "tb_turma")
public class Turma implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private TurmaPK id = new TurmaPK();
	
	private Integer quantity;

	public Turma() {
	}

	public Turma(Curso curso, Aluno aluno, Integer quantity) {
		super();
		id.setCurso(curso);
		id.setAluno(aluno); 
		this.quantity = quantity;
	}
	
	@JsonIgnore
	public Curso getCurso() {
		return id.getCurso();
	}
	
	public void setCurso(Curso curso) {
		id.setCurso(curso);
	}
	
	public Aluno getAluno() {
		return id.getAluno();
	}
	
	public void setAluno(Aluno aluno) {
		id.setAluno(aluno);
	}
	
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
