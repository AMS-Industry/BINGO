package com.company;

public interface CartonInterfaz {

    //Guarda un elemento en la array numsPlayer. Este elemento son los números del carton del jugador invocante.
    public void addNumsPlayer(int elem);

    //devuelve el numero de elementos guardados
    public int size();

    //comprueba si está vacia o no. True, si lo está. False, si no.
    public boolean isEmpty();

    //nos elimina del array numsPlayer el elemento (la bola que ha salido del bombo) que recibe como parámetro, si está.
    //Devuelve true si lo ha eliminado. False, si no.
    public boolean removeElems(int elem);

    //comprueba si quedan números en el array numsPlayer. Si no quedan, es bingo.
    //Devuelve true si es bingo. False, si no.
    public boolean esBingo();

    //Imprime los numeros en orden de salida
    String enCadenarNums();

}
