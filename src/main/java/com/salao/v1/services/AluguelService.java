package com.salao.v1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salao.v1.domain.Aluguel;
import com.salao.v1.exeption.AluguelAlreadyExistExeption;
import com.salao.v1.exeption.AluguelNotFoundExeption;
import com.salao.v1.repository.AluguelRepository;

@Service
public class AluguelService {

	@Autowired
	private AluguelRepository aluguelRepository;

	@Transactional(readOnly = true)
	public List<Aluguel> findAll() {
		return aluguelRepository.findAll();
	}

	@Transactional(readOnly = true)
	private boolean exist(Long idAluguel) {

		return aluguelRepository.existsById(idAluguel);
	}

	@Transactional(readOnly = false)
	public Aluguel save(Aluguel aluguel) {
		if (aluguel.getIdAluguel() != null && exist(aluguel.getIdAluguel())) {
			throw new AluguelAlreadyExistExeption("Aluguel com esse id ja existe" + aluguel.getIdAluguel());
		}

		return aluguelRepository.save(aluguel);
	}

	@Transactional(readOnly = true)
	public Aluguel findById(Long id) {
		if (!exist(id)) {
			throw new AluguelNotFoundExeption("Aluguel com esse id não existe:" + id);
		}
		return aluguelRepository.findById(id).orElse(null);
	}

	@Transactional(readOnly = false)
	public Aluguel update(Aluguel aluguel) {
		if (!exist(aluguel.getIdAluguel())) {
			throw new AluguelNotFoundExeption("Aluguel com esse id não existe:" + aluguel.getIdAluguel());
		}
		return aluguelRepository.save(aluguel);
	}

	@Transactional(readOnly = false)
	public void delete(Aluguel aluguel) {
		aluguelRepository.delete(aluguel);
	}

}
