package com.company;

public interface GenerarCartonInterfaz {
    //Añade un numero generado entre el 1-90 en el cartón.
    public boolean add(int elem, GenerarCarton [] carton);

    //Imprime el cartón.
    public void toString(GenerarCarton [] carton);
}
