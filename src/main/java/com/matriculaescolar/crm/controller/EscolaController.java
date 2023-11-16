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


import com.matriculaescolar.crm.model.Escola;
import com.matriculaescolar.crm.repository.EscolaRepository;

@RestController
@RequestMapping("/escolas")
public class EscolaController {

	@Autowired
	private EscolaRepository escolaRepository;
	
	@GetMapping
	public List<Escola> listarEscolas(){
		return escolaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Escola> verificarEscola(@PathVariable Long id) {
	    try {
	        Escola escola = escolaRepository.findById(id).orElseThrow();
	        return new ResponseEntity<>(escola, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping
	public Escola cadatrar(@RequestBody Escola escola) {
		return escolaRepository.save(escola);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Escola excluirEscola(@PathVariable Long id) {
	    try {
	        Escola escola = escolaRepository.findById(id).orElseThrow();
	        escolaRepository.delete(escola);
	        return escola;
	    } catch (Exception e) {
	        throw new RuntimeException("Não foi possivel encontrar a escola com o: " + id, e);
	    }
	}
	
	@PutMapping("/{id}")
	public Escola atualizarEscola(@PathVariable Long id, @RequestBody Escola escolaEscolhida) {
	    try {
	        Escola escola = escolaRepository.findById(id).orElseThrow();

	        escola.setNome(escolaEscolhida.getNome());
	        escola.setEndereco(escolaEscolhida.getEndereco());

	        Escola escolaAtualizada = escolaRepository.save(escola);
	        return escolaAtualizada;
	    } catch (Exception e) {
	        throw new RuntimeException("Erro ao atualizar o cadastro da escola com o ID: " + id, e);
	    }
	}
	
}
