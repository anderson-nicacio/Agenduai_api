package com.agenduai.recurso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agenduai.entidade.Local;
import com.agenduai.repositorio.LocalRepositorio;
import com.agenduai.servico.LocalServico;

@CrossOrigin
@RestController
@RequestMapping("/Local")
public class LocalRecurso {

	@Autowired
	private LocalRepositorio responseLocal;
	
	@Autowired
	private LocalServico localservico;
	
	// ------------------------ Post -------------------------- //
	
	@PostMapping("/SalvaLocal")
	public ResponseEntity<Local> Salva(@RequestBody Local local){
		
		return this.localservico.salvarLocal(local);
	}
	
	// ------------------------ Gets -------------------------- //
	
	@GetMapping("/BuscaLocal")
	public List<Local> Busca(){
		
		return this.responseLocal.findAll();
	}
	
	@GetMapping("/BuscaLocalNome/{nome}")
	public ResponseEntity<Local> BuscaNome(@PathVariable String nomeLocal){
		
		var local = this.responseLocal.findBynomeLocal(nomeLocal);
		return local.isPresent() ? ResponseEntity.ok(local.get()):
			ResponseEntity.notFound().build();
	}
	
	@GetMapping("/BuscaLocalCate/{categoLocal}")
	public ResponseEntity<Local> BuscaCategoria(@PathVariable String categoria){
		
		var local = this.responseLocal.findBycategoria(categoria);
		return local.isPresent() ? ResponseEntity.ok(local.get()):
			ResponseEntity.notFound().build();
	}
	
	@GetMapping("/BuscaLocalCapa/{capacLocal}")
	public ResponseEntity<Local> BuscaCapacidade(@PathVariable int capacidade){
		
		var local = this.responseLocal.findBycapacidade(capacidade);
		return local.isPresent() ? ResponseEntity.ok(local.get()):
			ResponseEntity.notFound().build();
	}
	
	// ------------------------- Put ------------------------- //
	
	@PutMapping("/AtualizaLocal")
	public String Atualiza(@RequestBody Local local) {
		
		this.responseLocal.save(local);
		return "Atualizado com Sucesso";
	}
	
	// ----------------------- Delete ---------------------- //
	
	@DeleteMapping("/DeletaLocal/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String DeletaLocal(@PathVariable int id_local) {
		
		this.responseLocal.deleteById(id_local);
		return "Local excluido com Sucesso";
	}
}
