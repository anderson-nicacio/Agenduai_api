package com.agenduai.recurso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenduai.entidade.Usuario;
import com.agenduai.repositorio.UsuarioRepositorio;
import com.agenduai.servico.UsuarioServico;

@CrossOrigin
@RestController
@RequestMapping("/Usuario")
public class UsuarioRecurso {
	
	@Autowired
	private UsuarioRepositorio responseUsuario;
	
	@Autowired
	private UsuarioServico usuarioservico;
	
	// ------------------------- Post ------------------------ //
	
	@PostMapping("/SalvaUsuario")
	public ResponseEntity<Usuario> Salva(@RequestBody Usuario usuario){
		
		return this.usuarioservico.salvar(usuario);
	}
	
	// ------------------------ Gets ------------------------- //
	
	@GetMapping("/BuscaUsuario")
	public List<Usuario> Busca(){
		
		return responseUsuario.findAll();
	}
	
	// ----------------------- Put -------------------------- //
	
	@PutMapping("/AtualizaUsuario")
	public String Atualiza(@RequestBody Usuario usuario) {
		
		this.responseUsuario.save(usuario);
		return "Atualizado com Sucesso";
	}

}
