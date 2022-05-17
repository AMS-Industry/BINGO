package com.company;

public class Partida implements PartidaInterfazz {
    int ronda;
    int numJugadores;

    int puntosLinea;
    int puntosBingo;

    boolean linea; //para saber si se ha hecho linea o no
    boolean bingo; //para saber si se ha hecho bingo o no

    Linea[] arrayLineas; //array que guardará todas las lineas, sabremos a que personaje pertenecen por i/3

    Jugador misJugadores[]; //el array de jugadores.
    BolasAparecidas misBolas;
    Bombo bolasSacadas;

    /**
     * La clase partida funcionará de forma similar al main.
     * @param jugadores un array con los jugadors que van jugar.
     * @param pBingos los puntos que vale el bingo
     * @param pLinea los puntos que vale la linea
     */
   public Partida(Jugador [] jugadores, int pBingos, int pLinea){ //reciba cartones,
      ronda =1;
      numJugadores = jugadores.length;
      linea=false;
      bingo=false;
      puntosBingo=pBingos;
      puntosLinea=pLinea;

      misJugadores=jugadores;

      bolasSacadas=new Bombo();
      misBolas = new BolasAparecidas();

      arrayLineas = new Linea[numJugadores*3];//tres lineas por jugador

        for(int j=0; j<arrayLineas.length; j++){ //lleva el control de las lineas que hay que añadir
            for(int k=0; k<3;k++) { //lleva el control de la fila de cada carton
                arrayLineas[j] = new Linea(misJugadores[j/3].carton[k]);  //instanciamos un objeto de la clase linea por cada una de las lineas de cada jugador
            }
        }



      while(!bingo) { //si no se ha hecho bingo
          System.out.println("--------------------------"+"Ronda numero "+ ronda + "---------------------------");
          System.out.println(" ");
          int bola= sacarBola(); //sacamos una bola del bombo


          System.out.println("Ha salido el numero " + bola); //imrpimimos la bola que ha salido
          System.out.println("");
          System.out.println(misBolas.toString()); //las bolas en orden de aparición
          System.out.println("");

          for(int j = 0; j<misJugadores.length && !bingo;j++){ //comprobamos si la tiene cada jugador

              if(misJugadores[j].numsPlayer.removeElems(bola)){ //la tendrá si al intentar borrarla de la clase carton, el resultado es true.

                  System.out.println("La tiene " + misJugadores[j].nombreJugador);
                  System.out.println("");

                  bingo = misJugadores[j].numsPlayer.esBingo(); //la variable bingo vale el resultado de llamar a esBingo con el cartón del jugador j.

                  if(bingo){ //si es bingo, te añaden los puntos, bingo y deja de comprobar a los demás jugadores.
                      System.out.println("");
                      System.out.println("BINGO DE " + misJugadores[j].nombreJugador.toUpperCase() + "!!!");
                      System.out.println("El orden de aparición de las bolas es " + misJugadores[j].numsPlayer.enCadenarNums());
                      System.out.println(" ");
                      misJugadores[j].añadirPuntos(puntosBingo);
                      System.out.println( misJugadores[j].nombreJugador + " ha conseguido " + puntosBingo + " puntos");

                  }
              }
          }

          if(!linea){ //se tiene que cantar linea y solo se puede hacer una vez.
              comprobarLinea(bola);

          }
             ronda++;
          System.out.println(" ");
          }
       }

    /**
     * Saca una bola del bombo
     * @return devuelve la bola sacada
     */
    public int sacarBola(){ //saca bolas hasta que sea bingo


            int bola = bolasSacadas.bolaSacada();

            misBolas.addBolas(bola);

            return bola;

    }

    /**
     * Este método llamará tantas veces como lineas en juego haya (si hay 3 personajes, pues habrá 9 lineas) al método
     * contenido de la clase Linea.
     * Si está contenido, llamará al método esLinea de la clase linea, para comprobar si era el último elemento o no.
     * Si lo era, y por tanto esLinea devolvería true. Nos dirá de quién es la linea, el orden de aparición de las bolas y le sumarán los
     * puntos.
     * @param bola, que es la bola sacada de bombo.
     */
    public void comprobarLinea(int bola){

       for(int i =0; i<arrayLineas.length && !linea; i++){ //una por linea (de 0-5)
           if(arrayLineas[i].contenido(bola)){
               if(arrayLineas[i].esLinea()){

                   System.out.println("HA CANTADO LINEA " + misJugadores[i/3].nombreJugador.toUpperCase() + "!!!");
                   System.out.println("El orden de aparición de las bolas de la linea es " + arrayLineas[i].toString());

                   System.out.println("");

                   misJugadores[i/3].añadirPuntos(puntosLinea);
                   System.out.println( misJugadores[i/3].nombreJugador + " ha conseguido " + puntosLinea + " puntos");
                   System.out.println("Tiene ahora " + misJugadores[i/3].puntos + " puntos");

                   linea= true;

                   //al hacer i/3, nos dirá el numero del jugador al que pertenece la linea
                   //de tal forma que si se ha cantado linea guardada en la pos 4, pertenecerá al jugador guardado en la posicion 1.
               }
           }
       }

    }
}
 //poner que no ha salido la bola de nadie nadie