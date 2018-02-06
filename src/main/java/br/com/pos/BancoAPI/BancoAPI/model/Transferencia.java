package br.com.pos.BancoAPI.BancoAPI.model;

public class Transferencia {

	private long numConta1;
	private long numConta2;
	private double valor;
	public long getNumConta1() {
		return numConta1;
	}
	public void setNumConta1(long numConta1) {
		this.numConta1 = numConta1;
	}
	public long getNumConta2() {
		return numConta2;
	}
	public void setNumConta2(long numConta2) {
		this.numConta2 = numConta2;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

}
