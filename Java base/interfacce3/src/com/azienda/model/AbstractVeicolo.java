package com.azienda.model;

public abstract class AbstractVeicolo implements Veicolo {
	private float velocitaMax;

	@Override
	public float getVelocitaMax() {
		return this.velocitaMax;
	}

	@Override
	public void setVelocitaMax(float velocitaMax) {
		this.velocitaMax = velocitaMax;
	}

	@Override
	public String toString() {
		return "velocitaMax=" + velocitaMax;
	}
}
