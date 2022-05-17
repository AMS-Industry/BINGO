package com.company;

public class TandaPartidas implements TandaPartidasInterfaz {

        int numeroRondas;
        int listaRondas [];
        int posicion;

        public TandaPartidas(int rondas){

            numeroRondas=rondas;

            posicion=0;

            listaRondas= new int[numeroRondas];


            for(int i =0; i<listaRondas.length; i++){
                listaRondas[i] = 0;
            }

        }

    /**
     * Comrpueba si se pueden jugar más partidas
     * @return true si se pueden, false si no.
     */
    public boolean isFull(){

            return (numeroRondas==0);

        }

    /**
     * Introduce el numero de partida en el que nos encontramos
     * @param partidas, numero de la partida.
     * @return True si cabe y por tanto, hay más partidas por jugar. False si no.
     */
        public boolean add(int partidas){
            boolean añadido = false;

            if(!isFull()){
                listaRondas[posicion]=partidas;
                posicion++;
                numeroRondas--;
                añadido = true;

            }

            return añadido;
        }
    }


