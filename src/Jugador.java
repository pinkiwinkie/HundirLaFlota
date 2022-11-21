import static cambiosInternos.Cambios.*;
import static logic.Barcos.*;
import static logic.Tablero.*;

import tools.Input;

public class Jugador {
    public static void colocarBarcos(char[][] tableroJugador, char[][] disparosJugador, int[] barcos) {
        int barco, i = 0;
        boolean colocado = false;
        System.out.println("Vamos a proceder a colocar los barcos.");
        do {
            do {
                barco = barcos[i];
                int orientacion, numeroCoordColumna, letraCoordFila;
                String coordenada;
                System.out.println("Barco de " + barco + " celdas.");
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
        } while (i != barcos.length - 1);
    }

    private static String pedirCoordenadas() {
        String coordenada;
        char primeraPosicion, segundaPosicion;
        boolean salirNum, salirLetra, salirFormato;

        do {
            salirNum = false;
            salirLetra = false;
            salirFormato = false;
            coordenada = Input.getString("Dime coordenada : ");
            if (coordenada.length() != 2)
                System.err.println("Solo pueden haber 2 caracteres.");
            else {
                primeraPosicion = coordenada.charAt(0);
                segundaPosicion = coordenada.charAt(1);
                if (!esLetraCorrecta(separarCoordenadaLetra(coordenada)))
                    System.err.println("Introduce una letra valida.");
                else
                    salirLetra = true;
                if (!esNumeroCorrecto(separarCoordenadaNumero(coordenada)))
                    System.err.println("Introduce un numero valido.");
                else
                    salirNum = true;
                if ((primeraPosicion > 48 && primeraPosicion < 58) || (segundaPosicion > 64 && segundaPosicion < 74))
                    System.err.println("El formato introducido no es correcto.");
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
                System.out.println("Introduce 1 o 2.");
            else
                salir = true;
        } while (!salir);
        return orientacion;
    }

    public static boolean disparos(char[][] disparosJugador, char[][] tableroPC, char[][] tableroJugador) {
        boolean hayDisparo = false, quedarse;
        String coordenada;
        System.out.println("Vamos a proceder a disparar");

        int numeroCoordColumna, letraCoordFila;
        coordenada = pedirCoordenadas();
        letraCoordFila = separarCoordenadaLetra(coordenada);
        numeroCoordColumna = separarCoordenadaNumero(coordenada);
        //T: tocado, X: disparo fallido.
        quedarse = false;
        do {
            if (disparosJugador[letraCoordFila][numeroCoordColumna] == 'T' || disparosJugador[letraCoordFila][numeroCoordColumna] == 'X') {
                System.out.println("Ya has disparado en esta coordenada");
                quedarse = true;
            } else {
                if (tableroPC[letraCoordFila][numeroCoordColumna] == 'B') {
                    tableroPC[letraCoordFila][numeroCoordColumna] = 'T';
                    disparosJugador[letraCoordFila][numeroCoordColumna] = 'T';
                    hayDisparo = true;
                    quedarse = false;
                } else {
                    disparosJugador[letraCoordFila][numeroCoordColumna] = 'X';
                    tableroPC[letraCoordFila][numeroCoordColumna] = 'X';
                    hayDisparo = true;
                }
            }
        } while (!quedarse);
        verTableroJugador(tableroJugador, tableroPC);
        return hayDisparo;
    }

}
