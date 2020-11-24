package com.company;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ZonaCombate {
    static final int MAXIMO=10;
    public static Semaphore guerra = new Semaphore(MAXIMO,true);
    private Jugador bonus;
    int threadfinalizados=0;
    int pfinal=0;
    String ganador="";

    public void entraralazona(Jugador jugador){
        try {
            guerra.acquire();
            System.out.println("El "+jugador.getName()+ " ha entrado en la zona");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void luchar(Jugador jugador){
        try {
            Random r = new Random();
            int dormir=r.nextInt(4000)+1000;
            Thread.sleep(dormir);
            threadfinalizados++;
            if(bonus==null){
                bonus=jugador;
                System.out.println("El jugador con bonus es "+bonus.getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void puntuacion(Jugador jugador){
        Random r = new Random();
        jugador.puntuacion=r.nextInt();
        int punt=jugador.puntuacion;
        if(bonus.getName().equals(jugador.getName())){
            jugador.puntuacion=jugador.puntuacion*2;
        }
        if(jugador.puntuacion>pfinal){
            pfinal=jugador.puntuacion;
            ganador=jugador.getName();
        }

    }
    public void salirdelazona(){
        if(threadfinalizados==10){
            System.out.println("5 jugadores han muerto");
            for(int i=0;i<5;i++){
                guerra.release();
            }
        }else if(threadfinalizados==15){
            System.out.println("Han acabado todo los hilos");
            System.out.println("El ganador es "+ganador+" con una puntuacion de "+pfinal);
        }
    }
}
