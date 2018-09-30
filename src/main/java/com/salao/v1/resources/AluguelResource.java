package com.salao.v1.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.salao.v1.domain.Aluguel;
import com.salao.v1.representacao.AluguelRepresentacao;
import com.salao.v1.services.AluguelService;

@CrossOrigin
@RestController
@RequestMapping("/alugueis")
public class AluguelResource {

	@Autowired
	private AluguelService aluguelService;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ResponseEntity<List<AluguelRepresentacao>> listAll() {
		List<Aluguel> alugueis = aluguelService.findAll();
		List<AluguelRepresentacao> aluguelRepresentacoes = new ArrayList<>();
		for (Aluguel a : alugueis) {
			aluguelRepresentacoes.add(new AluguelRepresentacao(a));
		}

		return ResponseEntity.ok(aluguelRepresentacoes);

	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<Void> cadastrar(@Valid @RequestBody AluguelRepresentacao aluguelRepresentacao) {
		Aluguel aluguel = aluguelService.save(AluguelRepresentacao.build(aluguelRepresentacao));

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aluguel.getIdAluguel())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<AluguelRepresentacao> findById(@PathVariable("id") Long id) {
		Aluguel aluguel = aluguelService.findById(id);
		AluguelRepresentacao aluguelRepresentacao = new AluguelRepresentacao(aluguel);
		return ResponseEntity.ok(aluguelRepresentacao);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody AluguelRepresentacao aluguelRepresentacao,
			@PathVariable("id") Long id) {
		aluguelRepresentacao.setIdentifier(id);

		aluguelService.update(AluguelRepresentacao.build(aluguelRepresentacao));

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody HttpEntity<AluguelRepresentacao> delete(@PathVariable("id") Long id) {
		Aluguel aluguelid = aluguelService.findById(id);
		AluguelRepresentacao aluguelRepresentacao = new AluguelRepresentacao(aluguelid);
		aluguelService.delete(aluguelid);
		return ResponseEntity.ok(aluguelRepresentacao);

	}
}
