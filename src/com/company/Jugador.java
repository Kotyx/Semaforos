package com.company;

public class Jugador extends Thread{

    ZonaCombate zonaCombate;
    public Jugador(ZonaCombate zonaCombate){
        this.zonaCombate=zonaCombate;
    }

    public int puntuacion;

    @Override
    public void run() {
        zonaCombate.entraralazona(this);
        zonaCombate.luchar(this);
        zonaCombate.salirdelazona();
        zonaCombate.puntuacion(this);
    }
}
