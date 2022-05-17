package com.company;

public class Jugador implements JugadorInterfaz {

    String nombreJugador;
    int puntos;
    GenerarCarton [] carton;
    Carton numsPlayer;
    Bombo bombo ;

    //CONSTRUCTOR
public Jugador(String nombre){

    nombreJugador=nombre;
    puntos=0;

    carton = new GenerarCarton[3]; //creo una array de listas
    numsPlayer=new Carton(); //un carton para el jugador, que almacenará los números de generarCarton
    bombo = new Bombo();

    for(int numLista=0; numLista<carton.length;numLista++){ //creamos las 3 listas y las guardamos cada una en una posición de nuestro array de listas (que se llama carton)
        carton[numLista]=new GenerarCarton();
    }

    generarCarton(); //se genera un cartón.

}

    /**
     * Suma los puntos que ya tenia el jugador con los que ha conseguido.
     * @param añadirPuntos, puntos para sumar al jugador.
     * @return el total de puntos
     */
    public int añadirPuntos(int añadirPuntos){
        puntos = puntos + añadirPuntos;
    return puntos;

}

    /**
     * Para que no se repitieran los números, hemos creado otra instancia de la clase bombo, esta nos sacará una bola y la añadirá
     * al una lista de nuestra array carton. De esta forma, nos aseguramos que no haya elementos repetidos en el carton.
     * Este proceso se repetirá 3 veces (pues hay 3 listas o filas por cartón) * 5 (números por fila)
     */
    public void generarCarton(){
    int lista=0;
    int contador;


    while(lista<3){//rellenar con numeros. Esto nos dirá en que fila del cartón estamos
        contador=0;
        while(contador<5){ //caben 5 numeros por fila
            int nR= bombo.bolaSacada();

            if (carton[lista].add(nR, carton)) {
                contador++;
                numsPlayer.addNumsPlayer(nR);

            }

        }
        lista++;
    }
}

    /**
     * Nos imprime el cartón generado directamente
     */
    public void imprimirDatos(){
        System.out.println("Este es el cartón de " + nombreJugador);
        carton[0].toString(carton);
        System.out.println("----------------------------------------------------------------------------------");
    }

    /**
     * Resetea todos los valores, manteniendo los mismos nombres para que sea funcional.
     * De esta forma, podremos mantener al jugador X, cambiandole el cartón.
     */
    public void reset(){
    //Mantengo todo con el mismo nombre, pero se crean objetos de nuevo
     bombo = new Bombo();
     numsPlayer= new Carton();

     //se crea la array de listas vacia.
     carton = new GenerarCarton[3];

        for(int numLista=0; numLista<carton.length;numLista++){
            carton[numLista]=new GenerarCarton();
        }
    generarCarton();
    }
}
