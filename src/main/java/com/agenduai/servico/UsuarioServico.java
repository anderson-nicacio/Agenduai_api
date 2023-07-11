package com.agenduai.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.agenduai.entidade.Usuario;
import com.agenduai.repositorio.UsuarioRepositorio;
import com.agenduai.util.GeradorURI;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio ResponseUsuario;
	
	public ResponseEntity<Usuario> salvar(Usuario usuario){
		
		var UsuarioValida = this.ResponseUsuario.findByDocumento(usuario.getDocumento());
		if(!UsuarioValida.isPresent()) {
		var UsuarioSalva = this.ResponseUsuario.save(usuario);
		return ResponseEntity.created(GeradorURI.geraURI(usuario.getIdUsuario())).body(UsuarioSalva);
		}else {
			return ResponseEntity.status(409).build();
		}
	}
}
