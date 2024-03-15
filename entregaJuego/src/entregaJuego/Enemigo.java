package entregaJuego;

import java.util.Random;

public class Enemigo {
	Random numeroRandom = new Random();
	String nombre;
	int vida,ataque,defensa,experiencia;

	Enemigo(){
		this.nombre = "x";
		this.vida = 500;
		this.ataque = 0;
		this.defensa = 0;
		this.experiencia= 50+ numeroRandom.nextInt(70);
	}
	String getNombre() {
		return nombre;
	}
	void setNombre(String nombre) {
		this.nombre = nombre;
	}
	int getVida() {
		return vida;
	}
	void setVida(int vida) {
		this.vida = vida;
	}
	int getAtaque() {
		return ataque;
	}
	void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	int getDefensa() {
		return defensa;
	}
	void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	int getExperiencia() {
		return experiencia;
	}
	void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}
}
