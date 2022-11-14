package logic;

public class Barcos {
    public static void colocarBarcos (char [][] tablero, int barco, int fila,
                                      int columna, int posicion){
        if (posicion == 1) {
            for (int i = 0; i < barco; i++) {
                if ((columna + barco) <= tablero.length)
                    tablero[fila][columna + i] = 'B';
            }
        } else{
            for (int i = 0; i < barco; i++) {
                if ((fila + barco) <= tablero[0].length)
                    tablero[fila + i][columna] = 'B';
            }
        }
    }
}
