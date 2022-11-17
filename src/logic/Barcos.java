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
        boolean colisiona;
        // he creado boolean jugador para mostrar los mensajes de error solo en la ronda del jugador.

        if (orientacionBarco == 1)
            colisiona = colisionHorizontal(tablero, longitudBarco, fila, columna, jugador);
        else
            colisiona = colisionVertical(tablero, longitudBarco, fila, columna, jugador);
        return colisiona;
    }

    public static boolean colisionVertical(char[][] tablero, int longitudBarco, int fila, int columna, boolean jugador) {

        for (int i = 0; i < longitudBarco; i++) {
            if ((fila + longitudBarco) <= tablero[0].length) {
                if (tablero[fila + i][columna] == 'B') {
                    if (jugador)
                        System.out.println("La casilla está ocupada.");
                    return true;
                }
                if (!alrededorVerticalVacio(tablero, fila, columna, jugador, i))
                    return true;
                if (!alrededorHorizontalVacio(tablero, fila, columna, jugador, i))
                    return true;
            } else {
                if (jugador)
                    System.out.println("El barco no cabe hacia abajo.");
                return true;

            }
        }
        return false;
    }

    public static boolean colisionHorizontal(char[][] tablero, int longitudBarco, int fila, int columna, boolean jugador) {
        for (int i = 0; i < longitudBarco; i++) {
            if ((columna + longitudBarco) <= tablero.length) { //comprobar que no sale del tablero.
                if (tablero[fila][columna + i] == 'B') {
                    if (jugador)
                        System.out.println("La casilla está ocupada.");
                    return true;
                }
                if (!alrededorHorizontalVacio(tablero, fila, columna, jugador, i))
                    return true;
                if (!alrededorVerticalVacio(tablero, fila, columna, jugador, i))
                    return true;
            } else {
                if (jugador)
                    System.out.println("El barco no cabe hacia la derecha.");
                return true;
            }
        }
        return false;
    }

    private static boolean alrededorVerticalVacio(char[][] tablero, int fila, int columna, boolean jugador, int i) {
        if (fila == 1 && columna == 1) {
            if (tablero[1+fila+i][columna] == 'B'){
                if (jugador)
                    System.out.println("No puedes poner un barco pegado de otro.");
                return false;
            }
        }

        return true;
    }

    private static boolean alrededorHorizontalVacio(char[][] tablero, int fila, int columna, boolean jugador, int i) {
        if (fila == 1 && columna == 1) {
            if (tablero[fila][1+columna+i] == 'B'){
                if (jugador)
                    System.out.println("No puedes poner un barco pegado de otro.");
                return false;
            }
        }
        return true;
    }
}
