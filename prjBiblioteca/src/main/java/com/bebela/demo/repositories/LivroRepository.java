package com.bebela.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bebela.demo.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
