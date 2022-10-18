package com.marcionascimento.projetoback.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.marcionascimento.projetoback.entidades.Aluno;
import com.marcionascimento.projetoback.entidades.Contato;
import com.marcionascimento.projetoback.entidades.Curso;
import com.marcionascimento.projetoback.entidades.Endereco;
import com.marcionascimento.projetoback.entidades.Turma;
import com.marcionascimento.projetoback.entidades.enums.Situacao;
import com.marcionascimento.projetoback.repositories.AlunoRepository;
import com.marcionascimento.projetoback.repositories.ContatoRepository;
import com.marcionascimento.projetoback.repositories.CursoRepository;
import com.marcionascimento.projetoback.repositories.EnderecoRepository;
import com.marcionascimento.projetoback.repositories.TurmaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Aluno a1 = new Aluno(null, "Marcio", null , "Masculino", "Solteiro");
		Aluno a2 = new Aluno(null, "Daiane", null , "Feminina", "Solteira");
		
		
		Endereco e1 = new Endereco(null, "Rua Carlos Alberto", "Vila Rosario", "Duque de Caxias", "RJ", "25041190", a1);
		Endereco e2 = new Endereco(null, "Eça de Queiros", "Pantanal", "Duque de Caxias", "RJ", "25041000", a2);
		//a1.setEndereco(e1);
		//a2.setEndereco(e2);
		
		Contato c1 = new Contato(null, "99999-9999", "contato1@gmail.com", "@contato1", a1);
		Contato c2 = new Contato(null, "88888-8888", "contato2@gmail.com", "@contato2", a2);
		//a1.setContato(c1);
		//a2.setContato(c2);
		
		Curso curso1 = new Curso(null, "Funcional", "Ginática", Situacao.ATIVA);
		Curso curso2 = new Curso(null, "Ballet", "Dança", Situacao.SUSPENSA);
						
		alunoRepository.saveAll(Arrays.asList(a1, a2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		contatoRepository.saveAll(Arrays.asList(c1, c2));
		cursoRepository.saveAll(Arrays.asList(curso1, curso2));
		
		Turma t1 = new Turma(curso1, a1, 20);
		Turma t2 = new Turma(curso2, a2, 0);
		
		turmaRepository.saveAll(Arrays.asList(t1, t2));
		

		
	}
	
	
}
