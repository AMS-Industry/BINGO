package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner entrada = new Scanner(System.in);

        int partidas;
        int numeroJugadores;

        Jugador [] misJugadores;

        System.out.println("Introduce el número de partidas a jugar");
        partidas= entrada.nextInt();

        TandaPartidas rondas = new TandaPartidas(partidas);


        do {

            System.out.println("¿Cuantos vais a jugar? 2-4");
            numeroJugadores = entrada.nextInt();

        }while(numeroJugadores>5 && numeroJugadores<1);

        misJugadores = new Jugador[numeroJugadores];

        int i = 0;
        do{
            System.out.println("Nombre del jugador número " + i);

            misJugadores[i]= new Jugador(entrada.next());
            i++;

        }while(i<numeroJugadores);




        int puntosLinea;
        int puntosBingo;

        do {
            System.out.println("¿Cuántos puntos por linea quieres?");
            puntosLinea = entrada.nextInt();
            System.out.println("¿Cuántos puntos por bingo quieres?");
            puntosBingo = entrada.nextInt();
        }while(puntosLinea<0 && puntosBingo<0);

        int numPartida=1;
        while(rondas.add(numPartida)){

            System.out.println("---------------------------------PARTIDA " + numPartida + "-------------------------------------------");

            for(int k =0; k < misJugadores.length; k++){
                misJugadores[k].imprimirDatos();
            }
            System.out.println("");

                Partida partida = new Partida(misJugadores, puntosBingo, puntosLinea);


            System.out.println("*************************************PARTIDA " + numPartida + " ACABADA********************************************");
            System.out.println("");

            for(int k =0; k < misJugadores.length; k++){
                System.out.println( misJugadores[k].nombreJugador + " tiene actualmente " +  misJugadores[k].puntos + " puntos");
                misJugadores[k].reset();
            }

            System.out.println("*********************************************************************************************************************");
            System.out.println(" ");
            numPartida++;
        }
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-FIN DEL JUEGO-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
        int maxPoints=0;
        String winner="";

        for(int m =0; m<misJugadores.length;m++){

            if(misJugadores[m].puntos>maxPoints){

                maxPoints=misJugadores[m].puntos;
                winner = misJugadores[m].nombreJugador;

            }
        }

        System.out.println("EL GANADOR ES ...");
        System.out.println("      .");
        System.out.println("      .");
        System.out.println("      .");
        System.out.println("      .");
        System.out.println(winner.toUpperCase() + "!!!!!!");
        System.out.println("FELICITACIONES");

    }
}
        //PUNTUACIONES
