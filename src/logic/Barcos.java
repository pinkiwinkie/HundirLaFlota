package logic;

public class Barcos {
    //1: horizontal, 2: vertical
    public static void colocarEnElTablero(char[][] tablero, int barco, int fila, int columna, int orientacionBarco) {
        if (orientacionBarco == 1) {
            if (barco != 1) {
                for (int i = 0; i < barco; i++) {
                    if ((columna + barco) <= tablero.length)
                        tablero[fila][columna + i] = 'B';
                }
            } else {

                if ((columna + barco) <= tablero.length)
                    tablero[fila][columna] = 'B';
            }

        } else {
            if (barco != 1) {
                for (int i = 0; i < barco; i++) {
                    if ((fila + barco) <= tablero[0].length)
                        tablero[fila + i][columna] = 'B';
                }
            } else {
                if ((fila + barco) <= tablero[0].length)
                    tablero[fila][columna] = 'B';
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
                if (!alrededorVerticalVacio(tablero, fila, columna, jugador,i))
                    return true;
                if (!alrededorHorizontalVacio(tablero, fila, columna, jugador,i))
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
                if (!alrededorHorizontalVacio(tablero, fila, columna, jugador,i))
                    return true;
                if (!alrededorVerticalVacio(tablero, fila, columna, jugador,i))
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
        //comprobar esquina superior izquierda y esquina superior derecha. (A,1) y (A,9).
        if ((fila == 1 && columna == 1) || (fila == 1 && columna == 9)) {
            if ((tablero[1 + fila][columna] == 'B') ){
                if (jugador)
                    System.out.println("No puedes poner un barco pegado de otro.");
                return false;
            }
            //comprobar esquina inferior izquierda y esquina inferior derecha. (I,1) y (I,9).
        } else if ((fila == 9 && columna == 1) || (fila == 9 && columna == 9)) {
            if (tablero[--fila][columna] == 'B') {
                if (jugador)
                    System.out.println("No puedes poner un barco pegado de otro.");
                return false;
            }
        } else if (fila==9) {
            if (tablero[--fila][columna] == 'B') {
                if (jugador)
                    System.out.println("No puedes poner un barco pegado de otro.");
                return false;
            }
        } else {
            //busca coincidencias en el interior del mapa.
            if ((tablero[--fila][columna] == 'B') || (tablero[2 + fila][columna] == 'B')) {
                if (jugador)
                    System.out.println("No puedes poner un barco pegado de otro.");
                return false;
            }
        }
        return true;
    }

    private static boolean alrededorHorizontalVacio(char[][] tablero, int fila, int columna, boolean jugador, int i) {
        //comprobar esquina superior izquierda y esquina inferior izquierda. (A,1) y (I,1).
        if ((fila == 1 && columna == 1) || (fila == 9 && columna == 1)) {
            if (tablero[fila][1 + columna] == 'B') {
                if (jugador)
                    System.out.println("No puedes poner un barco pegado de otro.");
                return false;
            }
            //comprobar esquina superior derecha y esquina inferior izquierda. (A,9) y (I,9).
        } else if ((fila == 1 && columna == 9) || (fila == 9 && columna == 9)) {
            if (tablero[fila][--columna] == 'B') {
                if (jugador)
                    System.out.println("No puedes poner un barco pegado de otro.");
                return false;
            }
            //comprobar que no salga del tablero haciendo la busqueda en la posición contigua.
        } else if (columna == 9) {
            if (tablero[fila][--columna] == 'B') {
                if (jugador)
                    System.out.println("No puedes poner un barco pegado de otro.");
                return false;
            }

//comprueba que haciendo la búsqueda no se salga por arriba ni por la izquierda del tablero.
        } else if ((columna == 1) || (fila == 1)) {
            if (tablero[fila][++columna] == 'B') {
                if (jugador)
                    System.out.println("No puedes poner un barco pegado de otro.");
                return false;
            }
            //busca coincidencias en el interior del mapa.
        } else {
            if ((tablero[fila][--columna] == 'B') || (tablero[fila][2 + columna] == 'B')) {
                if (jugador)
                    System.out.println("No puedes poner un barco pegado de otro.");
                return false;
            }
        }
        return true;
    }
}
