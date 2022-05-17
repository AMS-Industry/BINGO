package com.company;

public interface JugadorInterfaz {


    //Se añaden los puntos a los que ya tenia el jugador
    int añadirPuntos(int puntos);

    //Genera un cartón para poder jugar. Esto se hace automaticamente al instanciar a los jugadores
    void generarCarton();

    //Imprime el cartón del jugador.
    void imprimirDatos();

    //Reset para poder generar otro cartón.
    void reset();


}
