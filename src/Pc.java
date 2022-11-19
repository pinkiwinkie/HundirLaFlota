import static logic.Barcos.colocarEnElTablero;
import static logic.Barcos.hayColision;

public class Pc {
    public static void colocarBarcos(char[][] tableroPC, int[] barcos) {
        int barco;
        boolean colocado;

        for (int i = 0; i < barcos.length; i++) {
            do {
                barco = barcos[i];
                int columna = (int) (Math.random() * (9)+1);
                int fila = (int) (Math.random() * (9)+1);
                //se puede hacer entre 0 y 10 porque realmente lo que indica las letras son las filas que hay y
                //eso es una posicion por ende son numeros.
                int orientacion = (int) (Math.random() * (2 - 1 + 1) + 1);
                if (orientacion == 1) {
                    if (!hayColision(tableroPC, barco, fila, columna, 1, false)) {
                        colocarEnElTablero(tableroPC, barco, fila, columna, 1);
                        colocado = true;
                    } else
                        colocado = false;
                } else if (orientacion == 2) {
                    if (!hayColision(tableroPC, barco, fila, columna, 2, false)) {
                        colocarEnElTablero(tableroPC, barco, fila, columna, 2);
                        colocado = true;
                    } else
                        colocado = false;
                } else
                    colocado = false;
            } while (!colocado);
        }
    }
}
