package logic;

import static logic.Barcos.*;
import static logic.Tablero.*;

public class Pc {
    public static void colocarBarcos(char[][] tableroPC, int[] barcos, char[][] tableroDisparosPC) {
        int barco, i=0;
        boolean colocado;

        do{
            do {
                barco = barcos[i];
                int columna = getNumberRandom(9);
                int fila = getNumberRandom(9);
                //se puede hacer entre 0 y 10 porque realmente lo que indica las letras son las filas que hay y
                //eso es una posicion por ende son numeros.
                int orientacion = getNumberRandom(2 - 1 + 1);
                System.out.println(fila+" " + columna+" " + orientacion);
                if (orientacion == 1) {
                    if (!hayColision(tableroPC, barco, fila, columna, 1, false)) {
                        colocarEnElTablero(tableroPC, barco, fila, columna, 1);
                        colocado = true;
                        i++;
                    } else
                        colocado = false;
                } else if (orientacion == 2) {
                    if (!hayColision(tableroPC, barco, fila, columna, 2, false)) {
                        colocarEnElTablero(tableroPC, barco, fila, columna, 2);
                        colocado = true;
                        i++;
                    } else
                        colocado = false;
                } else
                    colocado = false;
                Tablero.verTableroPc(tableroPC,tableroDisparosPC);
            } while (!colocado);
        } while (i != barcos.length);
    }

    public static boolean disparos(char[][] disparosPC, char[][] tableroJugador, char[][] disparosJugador, char[][] tableroPC) {
        boolean hayDisparo = false, salir, descuentaVidaJugador = false;
        do {
            int columna = getNumberRandom(9);
            int fila = getNumberRandom(9);
//            System.out.println("columna " + columna + "fila " + fila);
            salir = false;
            do {
                if (disparosPC[fila][columna] == 'T' || disparosPC[fila][columna] == 'X') {
                    salir=true;
                } else {
                    if (tableroJugador[fila][columna] == 'B') {
                        tableroJugador[fila][columna] = 'T';
                        disparosPC[fila][columna] = 'T';
                        descuentaVidaJugador = true;

                    } else {
                        disparosPC[fila][columna] = 'X';
                        tableroJugador[fila][columna] = 'X';
                    }
                    hayDisparo = true;
                }
            } while (!salir);
        } while (!hayDisparo);
        verTableroJugador(tableroJugador, disparosJugador);
        verTableroPc(tableroPC, disparosPC);
        return descuentaVidaJugador;
    }

    private static int getNumberRandom(int x) {
        return (int) (Math.random() * x + 1);
    }
}
