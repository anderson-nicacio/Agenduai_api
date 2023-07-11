package com.agenduai.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.agenduai.entidade.Local;
import com.agenduai.repositorio.LocalRepositorio;
import com.agenduai.util.GeradorURI;

@Service
public class LocalServico {

	@Autowired
	private LocalRepositorio ResponseLocal;
	
	public ResponseEntity<Local> salvarLocal(Local local){
		
		var LocalValida = this.ResponseLocal.findByendereco(local.getEndereco());
		if(!LocalValida.isPresent()){
		var LocalSalva = this.ResponseLocal.save(local);
		return ResponseEntity.created(GeradorURI.geraURI(local.getIdLocal())).body(LocalSalva);
		}else{
			return ResponseEntity.status(409).build();
		}
	}
	
	
}
