package com.company;

public class NodoLista {

    NodoLista sig;
    int info;
    int pos;

    NodoLista(int elem){ //el elemento que llega es un numero random

        pos=elem/10; //2

        if(elem==90){
            pos=8;
        }

        sig = null;//null
        info=elem;//23
    }
    NodoLista(){
        //si es -1, significa que está vacio
        pos=-1;
        sig=null;
        info=-1;
    }

}
