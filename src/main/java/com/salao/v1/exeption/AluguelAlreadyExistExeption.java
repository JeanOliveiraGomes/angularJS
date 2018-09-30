package com.salao.v1.exeption;

public class AluguelAlreadyExistExeption extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AluguelAlreadyExistExeption(String mensagem) {
		super(mensagem);
	}

	public AluguelAlreadyExistExeption(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
