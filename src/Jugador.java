import static cambiosInternos.Cambios.*;

import tools.Input;

public class Jugador {
    public static void colocarBarcos(char[][] tableroJugador,
                                     char[][] disparosJugador,
                                     int[] barcos) {
        int barco;
        boolean colocado = false;
        System.out.println("Vamos a proceder a colocar los barcos.");
        for (int i = 0; i < barcos.length; i++) {
            do {
                barco = barcos[i];
                char fila;
                int columna, orientacion, numeroCoord, letraCoord;
                String aux, coordenada;
                System.out.println("Barco de " + barco + " celdas.");
                pedirCoordenadas();

            } while (!colocado);
        }
    }

    public static void pedirCoordenadas() {
        String coordenada;
        char primeraPosicion, segundaPosicion;
        boolean salirNum = false, salirLetra = false, salirFormato = false;

        do {
            coordenada = Input.getString("Dime coordenada donde quieres colocar: ");
            primeraPosicion = coordenada.charAt(0);
            segundaPosicion = coordenada.charAt(1);
            if (coordenada.length()>2)
                System.out.println("Solo pueden haber 2 caracteres");
            else{
                if (!esLetraCorrecta(separarCoordenadaLetra(coordenada)))
                    System.out.println("Introduce una letra valida.");
                else
                    salirLetra = true;
                if (!esNumeroCorrecto(separarCoordenadaNumero(coordenada)))
                    System.out.println("Introduce un numero valido.");
                else
                    salirNum = true;
                if ((primeraPosicion > 47 && primeraPosicion < 58) || (segundaPosicion > 64 && segundaPosicion < 74))
                    System.out.println("El formato introducido no es correcto.");
                else
                    salirFormato = true;
            }
        } while (!salirFormato || !salirLetra || !salirNum);
    }

}
