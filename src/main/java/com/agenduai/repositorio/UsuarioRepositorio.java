package com.agenduai.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenduai.entidade.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{

	public Optional<Usuario> findByDocumento(long documento);
}
