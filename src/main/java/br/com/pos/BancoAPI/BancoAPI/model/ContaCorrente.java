package br.com.pos.BancoAPI.BancoAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ContaCorrente {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long numConta;

   private double saldo;

   private long idcliente;

public long getNumConta() {
	return numConta;
}

public void setNumConta(long numConta) {
	this.numConta = numConta;
}

public double getSaldo() {
	return saldo;
}

public void setSaldo(double saldo) {
	this.saldo = saldo;
}

public long getIdcliente() {
	return idcliente;
}

public void setIdcliente(long idcliente) {
	this.idcliente = idcliente;
}

}
