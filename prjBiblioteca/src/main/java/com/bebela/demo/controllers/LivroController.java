package com.bebela.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bebela.demo.entities.Livro;
import com.bebela.demo.services.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	private final LivroService livroService;
	
	public LivroController (LivroService livroService) {
		this.livroService = livroService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Livro> findLivroById(@PathVariable Long Id){
		Livro livro = livroService.getLivroById(Id);
		
		if(livro != null) {
			return ResponseEntity.ok(livro);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Livro>> findAllLivro(){
		List<Livro>livros = livroService.getAllLivros();
		return ResponseEntity.ok(livros);
	}
	@PostMapping("/inserir")
	public ResponseEntity<Livro> insertLivro(@RequestBody Livro livro){
		Livro novoLivro = livroService.saveLivro(livro);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro);
	}
}
