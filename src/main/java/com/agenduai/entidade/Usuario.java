package com.agenduai.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_usuario;
	private String nomeUsuario;
	private long documento;
	private String telefone;
	private String senha;
	private String email;
	
	
	
	
	public Integer getIdUsuario() {
		return id_usuario;
	}
	public void setIdUsuario(Integer id_usuario) {
		 this.id_usuario =  id_usuario;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	
	public long getDocumento() {
		return documento;
	}
	public void setDocumento(long Documento) {
		documento = Documento;
	}
	
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
