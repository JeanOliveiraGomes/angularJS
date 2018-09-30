package com.salao.v1.exeption;

public class AluguelNotFoundExeption extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AluguelNotFoundExeption(String mensagem) {
		super(mensagem);
	}

	public AluguelNotFoundExeption(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
