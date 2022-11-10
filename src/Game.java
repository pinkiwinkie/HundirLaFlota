import static cambiosInternos.Cambios.*;
import static tablero.Tablero.*;

public class Game {
    public static void main(String[] args) {
        char [][] tablero = crearTablero();
        String lugar = "B5";
        System.out.println(separarCoordenadaLetra(lugar));
//        Jugabilidad.colocarBarcos(tablero, 3, letra, numeroCoordenada,2);
        verTablero(tablero);
    }
}
