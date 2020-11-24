package com.company;

public class Main {

    public static void main(String[] args) {

    	ZonaCombate z1=new ZonaCombate();

	    for(int i=0;i<15;i++){
	        Jugador jugador=new Jugador(z1);
	        jugador.setName("jugador "+i);
	        jugador.start();
        }
    }
}
