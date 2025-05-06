package com.bebela.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bebela.demo.entities.Livro;
import com.bebela.demo.repositories.LivroRepository;

@Service
public class LivroService {
	
	
	private LivroRepository livroRepository;
	
	@Autowired
	private LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}
	
	public Livro getLivroById(Long Id) {
		return livroRepository.findById(Id).orElse(null);
	}
	
	public List<Livro> getAllLivros(){
		return livroRepository.findAll();
	}
	
	public Livro saveLivro(Livro livro) {
		return livroRepository.save(livro);
	}
}
