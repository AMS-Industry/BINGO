package com.company;

public interface LineaInterfaz {

    //Comrpueba si el elem(bola que ha salido del bombo) está en la linea. Si está devuelve true.
    public boolean contenido(int elem);

    //Comprueba si es linea. True si es, false si no.
    public boolean esLinea();

    //Imprime los numeros de la linea en orden de aparición.
    public String toString ();
}
