package com.agenduai.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenduai.entidade.Local;

public interface LocalRepositorio extends JpaRepository<Local, Integer>{

	public Optional<Local> findBynomeLocal(String nomeLocal);
	public Optional<Local> findBycategoria(String categoria);
	public Optional<Local> findBycapacidade(Integer capacidade);
	public Optional<Local> findByendereco(String endereco);
}
