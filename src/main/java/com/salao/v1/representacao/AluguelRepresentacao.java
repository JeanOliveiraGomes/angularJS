package com.salao.v1.representacao;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.salao.v1.domain.Aluguel;

public class AluguelRepresentacao extends ResourceSupport {
	
	@JsonInclude(Include.NON_NULL)
	private Long identifier;
	@JsonInclude(Include.NON_NULL)
	private Date fimAnuncio;
	@JsonInclude(Include.NON_NULL)
	private String descricao;
	
	
	public AluguelRepresentacao() {
		super();
	}


	public AluguelRepresentacao(Aluguel aluguel) {
		super();
		this.identifier = aluguel.getIdAluguel();
		this.fimAnuncio = aluguel.getFimAnuncio();
		this.descricao = aluguel.getDescricao();
	}
	
	public static Aluguel build(AluguelRepresentacao aluguelRepresentacao) {
		Aluguel aluguel = new Aluguel();
		aluguel.setIdAluguel(aluguelRepresentacao.getIdentifier());
		aluguel.setFimAnuncio(aluguelRepresentacao.getFimAnuncio());
		aluguel.setDescricao(aluguelRepresentacao.getDescricao());
		
		return aluguel;
		
	}


	public Long getIdentifier() {
		return identifier;
	}


	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}


	public Date getFimAnuncio() {
		return fimAnuncio;
	}


	public void setFimAnuncio(Date fimAnuncio) {
		this.fimAnuncio = fimAnuncio;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
	
	
	
}
