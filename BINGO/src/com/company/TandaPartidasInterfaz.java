package com.company;

public interface TandaPartidasInterfaz {

    //Comprueba si el array que guardará el numero de partidas está lleno y, por tanto, se han acabado las partidas.
    public boolean isFull();

    //añade el numero de partida en el que nos encontramos al array. Cuando no se pueda añadir, es porque está lleno y por tanto, se han
    //acabado las partidas, pues el tamaño del array indica el número de partidas.
    public boolean add(int partidas);

}
