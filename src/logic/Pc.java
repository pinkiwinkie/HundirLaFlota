package logic;

import static logic.Ships.*;
import static logic.Board.*;

/**
 *
 */
public class Pc {
    /**
     * @param PcBoard board to put the boats.
     * @param ships   array with the boats to be placed.
     */
    public static void putShips(char[][] PcBoard, int[] ships) {
        int ship, i = 0;
        boolean putIt;

        do {
            do {
                ship = ships[i];
                int col = getRandomNumber(9);
                int row = getRandomNumber(9);
                //se puede hacer entre 0 y 10 porque realmente lo que indica las letras son las filas que hay y
                //eso es una posicion por ende son numeros.
                int orientation = getRandomNumber(2 - 1 + 1);
//                System.out.println(row+" " + col+" " + orientation);
                if (orientation == 1) {
                    if (!thereIsACollision(PcBoard, ship, row, col, 1, false)) {
                        putOnTheBoard(PcBoard, ship, row, col, 1);
                        putIt = true;
                        i++;
                    } else
                        putIt = false;
                } else if (orientation == 2) {
                    if (!thereIsACollision(PcBoard, ship, row, col, 2, false)) {
                        putOnTheBoard(PcBoard, ship, row, col, 2);
                        putIt = true;
                        i++;
                    } else
                        putIt = false;
                } else
                    putIt = false;
//                Tablero.verTableroPc(PcBoard,tableroDisparosPC);
            } while (!putIt);
        } while (i != ships.length);
    }

    /**
     * @param pcShootsBoard     to see the shots he has made.
     * @param playerBoard       board where the pc shoots.
     * @param playerShootsBoard to show it at the end of the whole.
     * @param pcBoard           to show it at the end of the whole.
     * @return true if discount user lives
     */
    public static boolean shoots(char[][] pcShootsBoard, char[][] playerBoard, char[][] playerShootsBoard, char[][] pcBoard) {
        boolean isShoot = false, exit, discountUserLives = false;
        do {
            int col = getRandomNumber(9);
            int row = getRandomNumber(9);
//            System.out.println("col " + col + "row " + row);
            exit = false;
            do {
                if (pcShootsBoard[row][col] == 'T' || pcShootsBoard[row][col] == 'X') {
                    exit = true;
                } else {
                    if (playerBoard[row][col] == 'B') {
                        playerBoard[row][col] = 'T';
                        pcShootsBoard[row][col] = 'T';
                        discountUserLives = true;

                    } else {
                        pcShootsBoard[row][col] = 'X';
                        playerBoard[row][col] = 'X';
                    }
                    isShoot = true;
                }
            } while (!exit);
        } while (!isShoot);
        showPlayerBoard(playerBoard, playerShootsBoard);
        showPcBoard(pcBoard, pcShootsBoard);
        return discountUserLives;
    }

    /**
     * (Math.random() * (max - min + 1) + min
     *
     * @param x = (max - min + 1) -->  Mark the lower and upper range
     * @return a random number inside the range.
     */
    private static int getRandomNumber(int x) {
        return (int) (Math.random() * x + 1);
    }

//    public static boolean disparosConIa(char[][] disparosPC, char[][] tableroJugador, char[][] disparosJugador, char[][] tableroPC) {
//        boolean hayDisparo = false, salir, descuentaVidaJugador = false;
//        int columna, fila;
////            System.out.println("columna " + columna + "fila " + fila);
//        columna = getNumberRandom(9);
//        fila = getNumberRandom(9);
//        do {
//            salir = false;
//            do {
//                if (disparosPC[fila][columna] == 'X')
//                    salir = true;
//                if (disparosPC[fila][columna] == 'T')
//                    if (disparosPC[fila][columna+1] == 'B')
//            } while (!salir);
//
//        } while (!hayDisparo);
//        verTableroJugador(tableroJugador, disparosJugador);
//        verTableroPc(tableroPC, disparosPC);
//        return descuentaVidaJugador;
//    }
}
