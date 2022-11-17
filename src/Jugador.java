import static cambiosInternos.Cambios.*;
import static logic.Barcos.*;

import logic.Tablero;
import tools.Input;

public class Jugador {
    public static void colocarBarcos(char[][] tableroJugador,char[][] disparosJugador, int[] barcos) {
        int barco, i = 0;
        boolean colocado = false;
        System.out.println("Vamos a proceder a colocar los barcos.");
        do {
            do {
                barco = barcos[i];
                int orientacion, numeroCoordColumna, letraCoordFila;
                String aux, coordenada;
                System.out.println("Barco de " + barco + " celdas.");
                coordenada = pedirCoordenadas();
                letraCoordFila = separarCoordenadaLetra(coordenada);
                numeroCoordColumna = separarCoordenadaNumero(coordenada);
                orientacion = pedirOrientacion();
                if (!hayColision(tableroJugador, barco, letraCoordFila, numeroCoordColumna, orientacion, true)) {
                    colocarEnElTablero(tableroJugador, barco, letraCoordFila, numeroCoordColumna, orientacion);
                    colocado = true;
                    i++;
                }
                Tablero.verTablero(tableroJugador,disparosJugador);
            } while (!colocado);
        } while (i != barcos.length - 1);

    }

    public static String pedirCoordenadas() {
        String coordenada;
        char primeraPosicion, segundaPosicion;
        boolean salirNum, salirLetra, salirFormato;

        do {
            salirNum = false;
            salirLetra = false;
            salirFormato = false;
            coordenada = Input.getString("Dime coordenada donde quieres colocar: ");
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

    public static int pedirOrientacion() {
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

}
