package com.company;

import java.util.Random;
public class Bombo implements BomboInterfaz {

    private final int MAXELEMS=90;

    int bombo[];

    int cardinal;

    public Bombo() {

        bombo = new int[MAXELEMS];
        cardinal=MAXELEMS;

        int j =0;
        for (int i = 1; i <= MAXELEMS; i++) {

            bombo[j]=i; //podria ponersse bombo[i-1]=i;
            j++;

        }
    }

    /**
     * Accede a una posición random de nuestro bombo (i) y guarda el numero de esa posición en num.
     *
     * @return num, el numero de la bola.
     */
    public int bolaSacada(){
        Random rand = new Random();
        int i = Math.abs(rand.nextInt()%cardinal);
        int num = bombo[i];
        remove(num);
        return num;
    }
    /**
     * Borra del bombo el elemento deseado y recoloca la array bombo
     * @param elem a borrar
     */
    public void remove (int elem){
        int pos=0;
        while(elem!=bombo[pos]){
            pos++;

        }

        for(int j = pos; j<cardinal-1; j++){
            bombo[j]=bombo[j+1];
        }
        cardinal--; //restamos uno a cardinal para que no recorra de forma innecesaria más posiciones de las debidas
    }


}
