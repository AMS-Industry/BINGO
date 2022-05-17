package com.company;

public class BolasAparecidas implements BolasAparecidasInterfaz {


    int listaBolas[];
    int maxElems=10;
    int size;
        //CONSTRUCTOR
     public BolasAparecidas(){ //añade a una array reescalable las bolas aparecidas


        listaBolas= new int[maxElems];
        size = 0;
    }

    /**
     *
     * @return el numero de elementos guardados
     */
    private int size(){

         return size;
    }

    /**
     * Si no cabe otra bola más, se reescala el array. Luego siempre, introducirá la bola en ListaBolas.
     * @param bola, que es la que ha salido en el bombo.
     * @return true, pues siempre es añadida
     */

    public boolean addBolas(int bola) {

         if(size()==maxElems){
             maxElems=maxElems*2;
             int aux [] = new int [maxElems];

             for(int i=0; i<listaBolas.length;i++){
                 aux[i]=listaBolas[i];
             }
             listaBolas=aux;
         }
         listaBolas[size]=bola;
         size++;

         return true;
    }

    /**
     * Nos imprimirá las bolas guardadas en listaBolas
     * @return c, que es la String que guarda nuestras bolas en orden de salida
     */

    @Override
    public String toString(){
         String c = "";

         for(int j =0; j<size(); j++){
             c= c+ listaBolas[j] + " ";
         }


         return "Bolas en orden de salida: " + c;
    }
}
