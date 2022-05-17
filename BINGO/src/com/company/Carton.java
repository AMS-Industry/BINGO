package com.company;

public class Carton implements CartonInterfaz{
    int [] numsPlayer;
    int [] bingoElems;
    int posBingoElems;

    int pos;
    int size;

    Carton(){
        numsPlayer= new int[15]; //15 son los numeros por cartón

        bingoElems=new int[15];
        posBingoElems=0;

        pos=0;
        size=15;
    }

    /**
     * guardamos todos los numeros de un cartón de un jugador
     * @param elem, numeros que tiene el jugador en su carton
     */
    public void addNumsPlayer(int elem){
        numsPlayer[pos] = elem;

        pos++;
    }

    public int size(){

        return(size);
    }

    public boolean isEmpty(){

        return (size()==0);
    }

    /**
     * nos elimina del cartón la bola sacada (si está)
     * @param elem, que es la bola sacada del bombo
     * @return true si ha sido borrado
     */
    public boolean removeElems(int elem){

            boolean deleted = false;
            int posBorrar=0;

            while(posBorrar<numsPlayer.length && !deleted){
                if(numsPlayer[posBorrar]==elem){
                    deleted=true;
                }
                else{
                    posBorrar++;
                }
            }
        if(deleted) {
            bingoElems[posBingoElems]=elem;
            posBingoElems++;
            for (int j = posBorrar; j < size() - 1; j++) {

                numsPlayer[posBorrar] = numsPlayer[posBorrar + 1];

            }
            size--;
        }
        return deleted;
    }

    /**
     * Comprueba si quedan numeros en el carton del jugador. Si no quedan, es porque ha hecho bingo.
     * @return true si es bingo, false si no.
     */
    public boolean esBingo(){

        return(isEmpty());
    }

    public String enCadenarNums(){
        String c = "";

        for(int i =0; i<bingoElems.length; i++){
            c=c + " " + bingoElems[i];
        }
        return c;
    }
}
