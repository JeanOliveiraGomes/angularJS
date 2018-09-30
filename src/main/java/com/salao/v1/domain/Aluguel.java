package com.salao.v1.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluguel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAluguel;
	private Date fimAnuncio;
	private String descricao;

	public Aluguel(Long idAluguel, Date fimAnuncio, String descricao) {
		super();
		this.idAluguel = idAluguel;
		this.fimAnuncio = fimAnuncio;
		this.descricao = descricao;
	}

	public Aluguel() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdAluguel() {
		return idAluguel;
	}

	public void setIdAluguel(Long idAluguel) {
		this.idAluguel = idAluguel;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAluguel == null) ? 0 : idAluguel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluguel other = (Aluguel) obj;
		if (idAluguel == null) {
			if (other.idAluguel != null)
				return false;
		} else if (!idAluguel.equals(other.idAluguel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluguel [idAluguel=" + idAluguel + ", fimAnuncio=" + fimAnuncio + ", descricao=" + descricao + "]";
	}

}
