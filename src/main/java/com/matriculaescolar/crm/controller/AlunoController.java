package com.matriculaescolar.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.matriculaescolar.crm.model.Aluno;
import com.matriculaescolar.crm.repository.AlunoRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping
	public List<Aluno> listarAlunos() {
		return alunoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> verificarAluno(@PathVariable Long id) {
	    try {
	        Aluno aluno = alunoRepository.findById(id).orElseThrow();
	        return new ResponseEntity<>(aluno, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Aluno cadastrarAluno(@RequestBody Aluno novoAluno) {
		return alunoRepository.save(novoAluno);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Aluno excluirAluno(@PathVariable Long id) {
	    try {
	        Aluno aluno = alunoRepository.findById(id).orElseThrow();
	        alunoRepository.delete(aluno);
	        return aluno;
	    } catch (Exception e) {
	        throw new RuntimeException("Não foi possivel encontrar o aluno com o: " + id, e);
	    }
	}

	@PutMapping("/{id}")
	public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno alunoEscolhido) {
	    try {
	        Aluno aluno = alunoRepository.findById(id).orElseThrow();

	        aluno.setNome(alunoEscolhido.getNome());
	        aluno.setEndereco(alunoEscolhido.getEndereco());
	        aluno.setIdade(alunoEscolhido.getIdade());

	        Aluno alunoAtualizado = alunoRepository.save(aluno);
	        return alunoAtualizado;
	    } catch (Exception e) {
	        throw new RuntimeException("Erro ao atualizar o cadastro do aluno com o ID: " + id, e);
	    }
	}

	
}
