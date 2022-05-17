package com.company;

import org.ietf.jgss.GSSName;

public class GenerarCarton implements GenerarCartonInterfaz{

        //ESTE MÉTODO SE LLAMA SIEMPRE DESDE LA CLASE JUGADOR EL MÉTODO generarCarton();
        NodoLista inicio;
        int size;

        //CONSTRUCTOR
        GenerarCarton(){
            inicio= null;
            size=0;

            //Nos crea los nodos de la lista (o fila de nuestro cartón) con un valor centinela. Luego solo tendríamos que meter los elementos
            //aleatorios en el cartón con un orden
            for(int i=0; i<9;i++){  //nos crea la lista con un valor centinela de -1 (esto significa que no hay ningun elemento introducido). Estas listas ya están enlazadas

                NodoLista nodoActual=inicio;
                NodoLista nuevoNodo = new NodoLista();

                if(i==0){
                    inicio=nuevoNodo;
                }
                else{
                    while(nodoActual.sig!=null){
                        nodoActual=nodoActual.sig;
                    }
                    nodoActual.sig=nuevoNodo;
                }

            }
        }

        /**
         * Cabe destacar que el tamaño de la lista depende de los elementos añadidos, no del numero de nodos.
         * @return el tamaño de la lista
         */
        private int size(){
            return size;
        }
        private boolean isEmpty(){
            return (size==0);
        }

        /**
         * Como el elemento debe añadirse en una columna de nuestro cartón determinada por el tamaño de dicho número,
         * al construir un nodo con ese número, hemos creado además un valor pos, que no es más que el resultado de dividir dicho
         * número entre diez y lo guardaremos en un int (que nos lo redondeará). Así, al salir el numero 3, pos=3/10=0.
         * El elemento se guardará en la columna cero. Este es el motivo por el que hemos creado la lista con nodos "vacíos"
         * @param elem, numero a añadir del 1-90 que sale de la clase Bombo instanciado desde Jugador
         * @param carton además recibe el cartón entero, con el resto de filas.
         * @return
         */
        public boolean add(int elem, GenerarCarton[] carton){ //este es el método que rellenará nuestras listas

            boolean added =false;

            NodoLista nuevoNodo = new NodoLista(elem);
            NodoLista nodoActual=inicio;

            for(int i=0; i<nuevoNodo.pos;i++){ //al salir del for, estarás en la columna en la que se debe introducir el elemento. PE; si es un 25, será la columna 2

                nodoActual=nodoActual.sig;

            }

            if(nodoActual.info==-1 && size()<5 && cabeColum(nuevoNodo.pos, carton, nuevoNodo.info )){ //comprobamos que ese elemento quepa, es decir, cumpla con los requisitos: que no haya 3 elems en la columna
                // y que no haya 5 nuúmeros en la fila
                nodoActual.info=nuevoNodo.info; //en ese nodo se escribe el valor del elemento
                added=true;
                size++;
            }
            return added;
        }

        /**
         * Este método nos comprobará si cabe en la columna
         * @param columna donde se va a guardar el elemento
         * @param carton pues para mirar las columnas, necesitamos tambien mirar las otras filas que se han guardado en la array de Carton
         * @param elem elemento a introducir
         * @return
         */
        private boolean cabeColum(int columna, GenerarCarton[] carton, int elem){ //método que te comprueba si cabe un elemento en la columna (es decir, si hay menos de 2 elementos en la columna)
            boolean cabe = false;
            boolean repetidos=false;

            NodoLista nodoActual; //creamos un nodo que recorrerá las listas

            int vacios =0; //nos comprobará si cabe o no cabe

            int [] elemsColum= new int[3]; //y una array que nos guardará los elementos que hay en la columna deseada

            for(int j = 0; j< carton.length;j++){//bucle que lleva el control de la lista en la que estamos

                nodoActual=carton[j].inicio; //inicializamos nodoActual a el inicio de la lista j;

                for(int i=0; i<columna;i++){  //colocamos nodoActual en la columna desseada de la lista j.

                    nodoActual=nodoActual.sig;

                }
                elemsColum[j]= nodoActual.info;  //guardamos esa información en la posición j de la array. Por ello, la info del elemento de la lista 0 se guardará en la pos 0 del array
            }

            for(int k=0; k<elemsColum.length;k++){  //para recorrer la array elemsColum
                if(elemsColum[k]==-1){ //si está nuestro valor centinela, que significa que está la posición vacia, sumamos uno al contador de huecos
                    vacios++;
                }

            if(vacios>1){ //si hay dos o tres huecos y si no está repetido, metemos el numero. Por tanto cabe = true;

                cabe=true;

            }

                //ESTA PARTE ES IRRELEVANTE, PUES COMO LOS NUMS LOS SACAMOS DEL BOMBO, NUNCA ESTARÁN REPETIDOS
           /* if (elemsColum[k]!=-1 && elemsColum[k] == elem) { //comprobamos que ese elemento a insertar no esté repetido
                repetidos=true;
            }*/
            }
            //&& !repetidos

            return cabe;
        }

        /**
         * Imprime los números de nuestro cartón. Si hay un -1, coloca asteriscos.
         * Para conservar la estética, si estamos en la columna cero solo colocará un asterisco. En el resto, dos.
         * Al entrar en este método, primero se ordenará el cartón para que los elementos situados más arriba sean menor que los situados abajo.
         * @param carton para imprimir
         */
        public void toString(GenerarCarton[] carton){

            ordenarCarton(carton); //Al entrara aquí, primero ordenará el cartón

            NodoLista nodoActual; //creamos un nodo que recorrerá las listas

            for(int j = 0; j< carton.length;j++){//bucle que lleva el control de la lista en la que estamos
                String c = "";

                nodoActual=carton[j].inicio; //inicializamos nodoActual a el inicio de la lista j;

                c = "FILA " + (j+1) + "       ";
                for(int i=0; i<9;i++){
                    if(nodoActual.info==-1){
                        if(i==0){
                            c=c+" *";
                        }
                        else{
                            c= c + " **" ;
                        }


                    }
                    else{
                        c = c + " " + nodoActual.info ;
                    }
                    nodoActual=nodoActual.sig;
                }
                System.out.println(c);
                System.out.println("");
            }
        }

        /**
         *En términos generales, accederá a la columna i de todas las listas y guardará los elementos en un array.
         * Luego encontrará donde se encuentra el elemento mayor de esos números guardados en la lista. Si el elemento mayor está
         * más arriba del menor, lo reordena.
         * Es interesante lo ya mencionado, el elemento de la fila 0 de nuestro cartón, coincide con la pos 0 de nuestra array.
         * Así es como sabemos en qué posición se encuentra.
         * @param carton, recibe el cartón entero.
         */
        private void ordenarCarton(GenerarCarton[] carton){

            NodoLista nodoActual; //creamos un nodo que recorrerá las listas

            NodoLista nodoMayor;
            NodoLista nodoMenor;
            int mayor;
            int menor;

            int posMayor=0;
            int posMenor=0;

            int [] elemsOrdenar= new int[3]; //y una array que nos guardará los elementos que hay en la columna deseada

            for(int j = 0; j<9;j++){//bucle que lleva el control la columna en la que estamos

                for(int i=0; i<3;i++){  //colocamos nodoActual en el inicio y guardamos los elementos de la columna 0 en elemsOrdenar

                    nodoActual = carton[i].inicio;

                    for(int k=0; k<j;k++){//buscar la columna adecuada

                        nodoActual=nodoActual.sig;

                    }

                    elemsOrdenar[i] = nodoActual.info;
                }

                //cuando salga de aquí que ordene los elemtnos de elemsOrdenar //sudar de los -1

                mayor=0;
                menor=91;
                for(int m =0; m<3; m++){

                    if(mayor<elemsOrdenar[m] ){
                        mayor=elemsOrdenar[m];
                        posMayor=m;
                    }
                    if(elemsOrdenar[m]!=-1 && menor>elemsOrdenar[m] ){
                        menor=elemsOrdenar[m];
                        posMenor=m;
                    }
                }

                //Si hya que ordenar
                if(posMayor<posMenor){
                    nodoMayor=carton[posMayor].inicio; //iniciamos el nodo nodoMayor al inicio de la lista donde está contenido
                    nodoMenor=carton[posMenor].inicio; //iniciamos el nodo nodoMenor al inicio de la lista donde está contenido

                    for(int l=0; l<j;l++){  //colocamos los nodos en la columna deseada

                        nodoMayor=nodoMayor.sig;
                        nodoMenor=nodoMenor.sig;
                    }

                    //Intercambiamos la información, lo que habia en el mayor lo ponemos en el menor y viceversa.
                    nodoMayor.info=menor;
                    nodoMenor.info=mayor;

                }
            }//fin del bucle que pasa por todas las columnas
        }



    }


