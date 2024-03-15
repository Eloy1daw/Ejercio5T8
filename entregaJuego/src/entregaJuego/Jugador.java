package entregaJuego;

import java.util.Random;

public class Jugador {
	String nombre;
	int vida,ataque,defensa,experiencia, numeroPotis, maximasPotis, nivel,maxExp;
	
	Random numeroRandom = new Random();

	Jugador(){
		this.nombre = "x";
		this.vida = 500;
		this.ataque =  51 + numeroRandom.nextInt(50);
		this.defensa = 1 + numeroRandom.nextInt(49);
		this.experiencia=0;
//		para poder sobrevivir mas
		this.numeroPotis=5;
		this.maximasPotis=5;
		this.nivel=1;
		this.maxExp=100;
	}
	
	int getNivel() {
		return nivel;
	}

	void setNivel(int nivel) {
		this.nivel = nivel;
	}

	int getMaxExp() {
		return maxExp;
	}

	void setMaxExp(int maxExp) {
		this.maxExp = maxExp;
	}

	int getMaximasPotis() {
		return maximasPotis;
	}
	void setMaximasPotis(int maximasPotis) {
		this.maximasPotis = maximasPotis;
	}
	int getNumeroPotis() {
		return numeroPotis;
	}
	void setNumeroPotis(int numeroPotis) {
		this.numeroPotis = numeroPotis;
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
