import cambiosInternos.Cambios;
import tools.Input;

public class Jugador {
    public static void colocarBarcos(char [][] tableroJugador,
                                     char[][] disparosJugador,
                                     int [] barcos){
        int barco;
        boolean colocado = false;
        System.out.println("Vamos a proceder a colocar los barcos.");
        for (int i = 0; i < barcos.length; i++) {
            do {
                barco=barcos[i];
                char fila;
                int columna, orientacion, numeroCoord, letraCoord;
                String aux,coordenada;
                System.out.println("Barco de " + barco + " celdas.");
                coordenada = Input.getString("Dime coordenada donde quieres colocar: ");

            } while (!colocado);
        }
    }

}
