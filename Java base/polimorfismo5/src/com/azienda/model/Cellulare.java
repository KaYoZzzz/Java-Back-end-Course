package com.azienda.model;

public class Cellulare extends DispositivoMultimediale {
	private int megaPixelCamera;

	public Cellulare(String marca, String modello, float prezzo, int megaPixelCamera) {
		super(marca, modello, prezzo);
		this.megaPixelCamera = megaPixelCamera;
	}

	public int getMegaPixelCamera() {
		return megaPixelCamera;
	}

	public void setMegaPixelCamera(int megaPixelCamera) {
		this.megaPixelCamera = megaPixelCamera;
	}

	public String chiama() {
		return "sto chiamando...";
	}

	public String rispondi() {
		return "sta squillando...";
	}
}
