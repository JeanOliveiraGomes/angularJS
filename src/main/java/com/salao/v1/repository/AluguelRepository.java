package com.salao.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salao.v1.domain.Aluguel;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {

	

}
