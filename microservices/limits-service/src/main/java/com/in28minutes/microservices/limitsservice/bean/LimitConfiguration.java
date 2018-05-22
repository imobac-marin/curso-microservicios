package com.in28minutes.microservices.limitsservice.bean;

public class LimitConfiguration {

	private int maximo;
	private int minimo;

	public int getMaximo() {
		return maximo;
	}

	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}

	public int getMinimo() {
		return minimo;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	public LimitConfiguration(int maximo, int minimo) {
		super();
		this.maximo = maximo;
		this.minimo = minimo;
	}

	protected LimitConfiguration() {

	}
}
