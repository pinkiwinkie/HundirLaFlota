package logic;

import static cambiosInternos.Cambios.*;
import static logic.Barcos.*;
import static logic.Tablero.*;

import tools.Input;

public class Jugador {
    public static void colocarBarcos(char[][] tableroJugador, char[][] disparosJugador, int[] barcos) {
        int barco, i=0;
        boolean colocado = false;
        System.out.println("We are going to fit the ships");
        do {
            do {
                barco = barcos[i];
                int orientacion, numeroCoordColumna, letraCoordFila;
                String coordenada;
                System.out.println("Boat of " + barco + " cells.");
                coordenada = pedirCoordenadas();
                letraCoordFila = separarCoordenadaLetra(coordenada);
                numeroCoordColumna = separarCoordenadaNumero(coordenada);
                if (barco != 1)
                    orientacion = pedirOrientacion();
                else
                    orientacion = 2;
                if (!hayColision(tableroJugador, barco, letraCoordFila, numeroCoordColumna, orientacion, true)) {
                    colocarEnElTablero(tableroJugador, barco, letraCoordFila, numeroCoordColumna, orientacion);
                    colocado = true;
                    i++;
                }
                verTableroJugador(tableroJugador, disparosJugador);
            } while (!colocado);
        } while (i != barcos.length);
    }

    private static String pedirCoordenadas() {
        String coordenada;
        char primeraPosicion, segundaPosicion;
        boolean salirNum, salirLetra, salirFormato;

        do {
            salirNum = false;
            salirLetra = false;
            salirFormato = false;
            coordenada = Input.getString("Type coordinate: ");
            if (coordenada.length() != 2)
                System.err.println("Only two character.");
            else {
                primeraPosicion = coordenada.charAt(0);
                segundaPosicion = coordenada.charAt(1);
                if (!esLetraCorrecta(separarCoordenadaLetra(coordenada)))
                    System.err.println("Introduce a valid letter.");
                else
                    salirLetra = true;
                if (!esNumeroCorrecto(separarCoordenadaNumero(coordenada)))
                    System.err.println("Introduce a valid number.");
                else
                    salirNum = true;
                if ((primeraPosicion > 48 && primeraPosicion < 58) || (segundaPosicion > 64 && segundaPosicion < 74))
                    System.err.println("The format is incorrect.");
                else
                    salirFormato = true;
            }
        } while (!salirFormato || !salirLetra || !salirNum);
        return coordenada;
    }

    private static int pedirOrientacion() {
        int orientacion;
        boolean salir = false;
        do {
            orientacion = Input.getInt("En que orientacion quiere el barco? (1: horizontal, 2: vertical) ");
            if (!esOrientacionCorrecta(orientacion))
                System.err.println("Introduce 1 or 2.");
            else
                salir = true;
        } while (!salir);
        return orientacion;
    }

    public static boolean disparos(char[][] disparosJugador, char[][] tableroPC, char[][] tableroJugador, char[][] disparosPC) {
        boolean hayDisparo = false, salir, descuentaVidaPc = false;
        String coordenada;
        System.out.println("Let's shoot.");
        do {
            int numeroCoordColumna, letraCoordFila;
            coordenada = pedirCoordenadas();
            letraCoordFila = separarCoordenadaLetra(coordenada);
            numeroCoordColumna = separarCoordenadaNumero(coordenada);
            //T: tocado, X: disparo fallido.
            salir = false;
            do {
                if (disparosJugador[letraCoordFila][numeroCoordColumna] == 'T' || disparosJugador[letraCoordFila][numeroCoordColumna] == 'X') {
                    System.err.println("You have already shoot at this coordinate.");
                    salir = true;
                } else {
                    if (tableroPC[letraCoordFila][numeroCoordColumna] == 'B') {
                        tableroPC[letraCoordFila][numeroCoordColumna] = 'T';
                        disparosJugador[letraCoordFila][numeroCoordColumna] = 'T';
                        descuentaVidaPc = true;
                        if ((alrededorHorizontalVacio(tableroPC,letraCoordFila,numeroCoordColumna,false,0))&&
                                (alrededorVerticalVacio(tableroPC,letraCoordFila,numeroCoordColumna,false,0)))
                            System.out.println("Barco tocado y hundido");
                        else
                            System.out.println("Barco tocado.");
                        hayDisparo = true;
                    } else {
                        disparosJugador[letraCoordFila][numeroCoordColumna] = 'X';
                        tableroPC[letraCoordFila][numeroCoordColumna] = 'X';
                        hayDisparo = true;
                    }
                }
            } while (!salir);
        } while (!hayDisparo);

        verTableroJugador(tableroJugador, disparosJugador);
        verTableroPc(tableroPC, disparosPC);
        return descuentaVidaPc;
    }

}
