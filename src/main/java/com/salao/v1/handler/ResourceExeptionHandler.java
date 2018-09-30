package com.salao.v1.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.salao.v1.exeption.AluguelAlreadyExistExeption;
import com.salao.v1.exeption.AluguelNotFoundExeption;

@ControllerAdvice
public class ResourceExeptionHandler {

	// Aluguel

	@ExceptionHandler(AluguelNotFoundExeption.class)
	public ResponseEntity<ErrorDetails> handlerAluguelNotFoundExeption(AluguelNotFoundExeption e,
			HttpServletRequest request) {

		e.printStackTrace();

		ErrorDetails error = new ErrorDetails();
		error.setStatus((long) 4041);
		error.setTitle("Aluguel not Found");
		error.setMessage(e.getMessage());
		error.setUrl("http://error.teste.com/404");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

	}

	@ExceptionHandler(AluguelAlreadyExistExeption.class)
	public ResponseEntity<ErrorDetails> handlerAlreadyExistExeption(AluguelAlreadyExistExeption e,
			HttpServletRequest request) {

		e.printStackTrace();

		ErrorDetails error = new ErrorDetails();
		error.setStatus((long) 4091);
		error.setTitle("Aluguel already exist");
		error.setMessage(e.getMessage());
		error.setUrl("http://error.teste.com/409");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);

	}

}
