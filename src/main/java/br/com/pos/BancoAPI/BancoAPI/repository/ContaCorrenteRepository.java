package br.com.pos.BancoAPI.BancoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pos.BancoAPI.BancoAPI.model.ContaCorrente;


public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, String> {
	
	ContaCorrente findByNumConta(long numConta);
	
	
	

}
