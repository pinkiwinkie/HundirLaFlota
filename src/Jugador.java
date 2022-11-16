import static cambiosInternos.Cambios.*;

import tools.Input;

public class Jugador {
    public static void colocarBarcos(char[][] tableroJugador, int[] barcos) {
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
                orientacion= pedirOrientacion();
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
                System.err.println("Solo pueden haber 2 caracteres");
            else{
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
    }

    public static int pedirOrientacion(){
        int orientacion;
        boolean salir = false;
        do {
            orientacion=Input.getInt("En qué orientación quiere el barco? (1: horizontal, 2: vertical) ");
            if (orientacion!=1&&orientacion!=2)
                System.out.println("Introduce 1 o 2");
            else
                salir=true;
        }while (!salir);
        return orientacion;
    }

}
