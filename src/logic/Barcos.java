package logic;

public class Barcos {
    //1: horizontal, 2: vertical
    public static void colocarEnElTablero(char[][] tablero, int barco, int fila, int columna, int orientacionBarco) {
        if (orientacionBarco == 1) {
            for (int i = 0; i < barco; i++) {
                if ((columna + barco) <= tablero.length)
                    tablero[fila][columna + i] = 'B';
            }
        } else {
            for (int i = 0; i < barco; i++) {
                if ((fila + barco) <= tablero[0].length)
                    tablero[fila + i][columna] = 'B';
            }
        }
    }

    public static boolean hayColision(char[][] tablero, int longitudBarco, int fila, int columna, int orientacionBarco, boolean jugador) {
        boolean colisiona = false;
        // lo de jugador está porque así cuando juega el pc no te muestra por pantalla los mensajitos que van para el jugador.

        if (orientacionBarco == 1) {
            for (int i = 0; i < longitudBarco; i++) {
                if ((columna + longitudBarco) <= tablero.length) { //comprobar que no sale del tablero.

                    if (tablero[fila][columna + i] == 'B') {
                        if (jugador)
                            System.out.println("La casilla está ocupada");

                        colisiona = true;
                    }
                    //comprobar que los barcos no se toquen, es decir, agua alrededor del barco.

                } else {
                    if (jugador)
                        System.out.println("El barco no cabe hacia la derecha");
                    colisiona = true;
                }
            }
        } else {
            for (int i = 0; i < longitudBarco; i++) {
                if ((fila + longitudBarco) <= tablero[0].length) {
                    if (tablero[fila + i][columna] == 'B') {
                        if (jugador)
                            System.out.println("La casilla está ocupada");
                        colisiona = true;
                    }
                } else {
                    if (jugador)
                        System.out.println("El barco no cabe hacia abajo");
                    colisiona = true;

                }
            }
        }
        return colisiona;
    }
}
