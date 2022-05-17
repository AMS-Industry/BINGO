package com.company;

public class Linea implements LineaInterfaz{

    int nums;
    int orden;
    int[] ordenAparicion;
    GenerarCarton filaX;


    //CONSTRUCTOR
   public Linea(GenerarCarton fila){
        filaX=fila;
        nums = 5;
        orden=0;
        ordenAparicion= new int[5]; //son los números que hay por fila, es decir, 5.
   }


    /**
     * Busca ese elemento en la lista (o fila del carton) que recibe como parámetro y resta una a nums si está.
     * @param elem, es la bola sacada del bombo
     * @return true si estaba contenido el elemento, por tanto la tiene un jugador. False, si no.
     */
    public boolean contenido(int elem){

       boolean contenido = false;
        NodoLista nodoFila;
        nodoFila = filaX.inicio;
        while(nodoFila.info!=elem && nodoFila.sig!=null){

            nodoFila=nodoFila.sig;

        }
        if(nodoFila.info==elem){
            ordenAparicion[orden] = elem; //guardo en la array ordenAparicion el elemento que está en la fila.
            orden++;
            contenido = true;
            nums--;
        }
        return contenido;
    }

    /**
     * Comprueba si es linea o no.
     * @return true si es linea, es decir, nums es cero.
     */
    public boolean esLinea(){
        boolean esLinea = false;

       if(nums==0){

        esLinea=true;

       }
       return esLinea;
    }

    /**
     * Imprime el orden en el que han aparecido los numeros para cantar linea.
     * @return la string de los numeros de la fila en orden de aparición.
     */
    @Override
    public String toString (){
        String l= "";

        for(int i =0; i<ordenAparicion.length;i++){
            l = l  + " "+ ordenAparicion[i];
        }
       return l;
    }
}
