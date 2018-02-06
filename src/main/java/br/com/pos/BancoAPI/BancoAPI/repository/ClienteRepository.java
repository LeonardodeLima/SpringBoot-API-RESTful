package br.com.pos.BancoAPI.BancoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pos.BancoAPI.BancoAPI.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, String> {
	
	Cliente findByCodigo(long codigo);
	
	
	

}
