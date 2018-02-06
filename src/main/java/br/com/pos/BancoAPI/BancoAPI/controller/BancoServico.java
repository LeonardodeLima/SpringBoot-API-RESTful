package br.com.pos.BancoAPI.BancoAPI.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.pos.BancoAPI.BancoAPI.model.ContaCorrente;
import br.com.pos.BancoAPI.BancoAPI.model.Transferencia;
import br.com.pos.BancoAPI.BancoAPI.repository.ContaCorrenteRepository;


@RestController
@RequestMapping("/evento")
public class BancoServico {

//	@Autowired
//	private ClienteRepository clienteRepo;
	@Autowired
	private ContaCorrenteRepository contaRepo;

	@PostMapping("/abrirconta")
	public ContaCorrente abrirConta(@RequestBody ContaCorrente conta) {
		return contaRepo.save(conta);
	}

	@GetMapping(value="/consultasaldo/{numConta}",produces="application/json")
	public @ResponseBody double consultarSaldo(@PathVariable(value="numConta") long numConta) {
		return contaRepo.findByNumConta(numConta).getSaldo();
	}

	@PostMapping("/depositar")
	public @ResponseBody ContaCorrente realizarDeposito(@RequestBody @Valid ContaCorrente conta) {
		ContaCorrente contaCadastrada = contaRepo.findByNumConta(conta.getNumConta());
		contaCadastrada.setSaldo(contaCadastrada.getSaldo() + conta.getSaldo());
		return contaRepo.saveAndFlush(contaCadastrada);
	}

	@PostMapping("/saque")
	public @ResponseBody ContaCorrente realizarSaque(@RequestBody @Valid ContaCorrente conta) {
		ContaCorrente contaCadastrada = contaRepo.findByNumConta(conta.getNumConta());
		contaCadastrada.setSaldo(contaCadastrada.getSaldo() - conta.getSaldo());
		return contaRepo.saveAndFlush(contaCadastrada);
	}

	@PostMapping("/transferir")
	public @ResponseBody void realizarTransferir(
			@RequestBody @Valid Transferencia tranferencia) {

		ContaCorrente c1 = contaRepo.findByNumConta(tranferencia.getNumConta1());
		ContaCorrente c2 = contaRepo.findByNumConta(tranferencia.getNumConta2());

		if (c1 != null && c2 != null)
		{
			c1.setSaldo(c1.getSaldo() - tranferencia.getValor());
			c2.setSaldo(c2.getSaldo() + tranferencia.getValor());

			contaRepo.saveAndFlush(c1);
			contaRepo.saveAndFlush(c2);
		}
	}
}
