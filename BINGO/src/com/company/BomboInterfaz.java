package com.company;

public interface BomboInterfaz {

    /**
     *Saca una bola entre el 1 y el 90 de nuestro bombo
     */
    public int bolaSacada();

    /**
     *Elimina esa bola del bombo para que no pueda volver a salir.
     */
   public void remove(int elem);

}
