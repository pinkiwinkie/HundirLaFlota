package logic;

public class Ships {
    //1: horizontal, 2: vertical

    /**
     * @param board           board to put the boats.
     * @param ship            to put.
     * @param row             row where to put the boat.
     * @param col             col where to put the boat.
     * @param shipOrientation of the boat to be added.
     */
    public static void putOnTheBoard(char[][] board, int ship, int row, int col, int shipOrientation) {
        if (shipOrientation == 1) {
            if (ship != 1) {
                for (int i = 0; i < ship; i++) {
                    if ((col + ship) <= board.length)
                        board[row][col + i] = 'B';
                }
            } else {
                if ((col + ship) <= board.length)
                    board[row][col] = 'B';
            }
        } else {
            if (ship != 1) {
                for (int i = 0; i < ship; i++) {
                    if ((row + ship) <= board[0].length)
                        board[row + i][col] = 'B';
                }
            } else {
                if ((row + ship) <= board[0].length)
                    board[row][col] = 'B';
            }
        }
    }

    /**
     * @param board      to see coordinate and ships.
     * @param row        in the coordinate.
     * @param col        in the coordinate.
     * @param player     to show messages.
     * @param shipLength to keep in mind that the restrictions are inside the dashboard.
     * @return true if it is free and
     * false if is not free.
     */
    public static boolean thereIsACollision(char[][] board, int shipLength, int row, int col, int shipOrientation, boolean player) {
        boolean collides;
        // he creado boolean player para mostrar los mensajes de error solo en la ronda del player.

        if (shipOrientation == 1)
            collides = horizontalCollision(board, shipLength, row, col, player);
        else
            collides = verticalCollision(board, shipLength, row, col, player);
        return collides;

    }

    /**
     * @param board      to see coordinate and ships.
     * @param row        in the coordinate.
     * @param col        in the coordinate.
     * @param player     to show messages.
     * @param shipLength to keep in mind that the restrictions are inside the dashboard.
     * @return true if it is free and
     * false if is not free.
     */
    private static boolean verticalCollision(char[][] board, int shipLength, int row, int col, boolean player) {
        if (shipLength == 1) {
            if ((row + shipLength) <= board[0].length) {
                if (board[row][col] == 'B') {
                    if (player)
                        System.err.println("The cell is occupied.");
                    return true;
                }
                if (!alrededorVerticalVacio(board, row, col, player, 0))
                    return true;
                if (!alrededorHorizontalVacio(board, row, col, player, 0))
                    return true;
            } else {
                if (player)
                    System.err.println("The ship does not fit down.");
                return true;
            }
        } else {
            for (int i = 0; i < shipLength; i++) {
                if ((row + shipLength) <= board[0].length) {
                    if (board[row + i][col] == 'B') {
                        if (player)
                            System.err.println("The cell is occupied.");
                        return true;
                    }
                    if (!alrededorVerticalVacio(board, row, col, player, i))
                        return true;
                    if (!alrededorHorizontalVacio(board, row, col, player, i))
                        return true;
                } else {
                    if (player)
                        System.err.println("The ship does not fit down.");
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param board      to see coordinate and ships.
     * @param row        in the coordinate.
     * @param col        in the coordinate.
     * @param player     to show messages.
     * @param shipLength to keep in mind that the restrictions are inside the dashboard.
     * @return true if it is free and
     * false if is not free.
     */
    private static boolean horizontalCollision(char[][] board, int shipLength, int row, int col, boolean player) {
        if (shipLength == 1) {
            if (board[row][col] == 'B') {
                if (player)
                    System.err.println("The cell is occupied.");
                return true;
            }
            if (!alrededorHorizontalVacio(board, row, col, player, 0))
                return true;
            if (!alrededorVerticalVacio(board, row, col, player, 0))
                return true;
        } else {
            for (int i = 0; i < shipLength; i++) {
                if ((col + shipLength) <= board.length) { //comprobar que no sale del board.
                    if (board[row][col + i] == 'B') {
                        if (player)
                            System.err.println("The cell is occupied.");
                        return true;
                    }
                    if (!alrededorHorizontalVacio(board, row, col, player, i))
                        return true;
                    if (!alrededorVerticalVacio(board, row, col, player, i))
                        return true;
                } else {
                    if (player)
                        System.err.println("The ship does not fit to the right.");
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param board  to see coordinate and ships.
     * @param row    in the coordinate.
     * @param col    in the coordinate.
     * @param player to show messages.
     * @param i      ship length.
     * @return true if it is free and
     * false if is not free.
     */
    public static boolean alrededorVerticalVacio(char[][] board, int row, int col, boolean player, int i) {
        //comprobar esquina superior izquierda y esquina superior derecha. (A,1) y (A,9).
        if ((row == 1 && col == 1) || (row == 1 && col == 9)) {
            if (!isFreeNextRow(board, row, col, player, i))
                return false;

            //comprobar esquina inferior izquierda y esquina inferior derecha. (I,1) y (I,9).
        } else if ((row == 9 && col == 1) || (row == 9 && col == 9)) {
            if (!isFreePreviousRow(board, row, col, player, i))
                return false;
        } else if (row == 9) {
            if ((!isFreePreviousRow(board, row, col, player, i)) || (!esColumnaSiguienteLibre(board, row, col, player, i)))
                return false;
        } else if (col == 1) {
            if ((!isFreeNextRow(board, row, col, player, i)) || (!isFreePreviousRow(board, row, col, player, i)))
                return false;
        } else if (col == 9) {
            if ((!isFreeNextRow(board, row, col, player, i)) || (!isFreePreviousRow(board, row, col, player, i)) || (!esColumnaAnteriorLibre(board, row, col, player, i)))
                return false;
        } else if (row == 1) {
            if ((!isFreeNextRow(board, row, col, player, i)) || (!esColumnaAnteriorLibreOColumnaSiguienteLibre(board, row, col, player, i)))
                return false;
        } else {
            //busca coincidencias en el interior del mapa.
            if ((!esColumnaAnteriorLibreOColumnaSiguienteLibre(board, row, col, player, i)) || (!esFilaAnteriorLibreOFilaSiguienteLibre(board, row, col, player, i)))
                return false;
        }
        return true;
    }

    /**
     * @param board  to see coordinate and ships
     * @param row    in the coordinate
     * @param col    in the coordinate
     * @param player to show messages
     * @param i      ship length
     * @return true if it is free and
     * false if is not free
     */
    public static boolean alrededorHorizontalVacio(char[][] board, int row, int col, boolean player, int i) {
        //comprobar esquina superior izquierda y esquina inferior izquierda. (A,1) y (I,1).
        if ((row == 1 && col == 1) || (row == 9 && col == 1)) {
            if (!esColumnaSiguienteLibre(board, row, col, player, i))
                return false;
            //comprobar esquina superior derecha y esquina inferior izquierda. (A,9) y (I,9).
        } else if ((row == 1 && col == 9) || (row == 9 && col == 9)) {
            if (!esColumnaAnteriorLibre(board, row, col, player, i))
                return false;
            //comprobar que no salga del board haciendo la busqueda en la posición contigua.
        } else if (col == 9) {
            if ((!esColumnaAnteriorLibre(board, row, col, player, i)) || (!isFreePreviousRow(board, row, col, player, i)))
                return false;
//comprueba que haciendo la búsqueda no se salga por arriba ni por la izquierda del board.
        } else if ((row == 1) || (col == 1)) {
            if ((!esColumnaSiguienteLibre(board, row, col, player, i)) || (!esColumnaAnteriorLibre(board, row, col, player, i)) || (!isFreeNextRow(board, row, col, player, i)))
                return false;
        } else if (row == 9) {
            if ((!isFreePreviousRow(board, row, col, player, i)) || (!esColumnaSiguienteLibre(board, row, col, player, i)) || (!esColumnaAnteriorLibre(board, row, col, player, i)))
                return false;
//busca coincidencias en el interior del mapa
        } else {
            if (((!esFilaAnteriorLibreOFilaSiguienteLibre(board, row, col, player, i))) || (!esColumnaSiguienteLibre(board, row, col, player, i)))
                return false;
        }
        return true;
    }

    /**
     * @param board  to see coordinate and ships
     * @param row    in the coordinate
     * @param col    in the coordinate
     * @param player to show messages
     * @param i      ship length
     * @return true if it is free and
     * false if is not free
     */
    private static boolean esColumnaAnteriorLibreOColumnaSiguienteLibre(char[][] board, int row, int col, boolean player, int i) {
        if (row + i < 10) {
            if ((board[row + i][col - 1] == 'B') || (board[row + i][col + 1] == 'B')) {
                if (player)
                    System.err.println("You can not put a ship attached to another.");
                return false;
            }
        }
        return true;
    }

    /**
     * @param board  to see coordinate and ships
     * @param row    in the coordinate
     * @param col    in the coordinate
     * @param player to show messages
     * @param i      ship length
     * @return true if it is free and
     * false if is not free
     */
    private static boolean esColumnaSiguienteLibre(char[][] board, int row, int col, boolean player, int i) {
        if (col + (i + 1) < 10) {
            if (board[row][col + (i + 1)] == 'B') {
                if (player)
                    System.err.println("You can not put a ship attached to another.");
                return false;
            }
        }
        return true;
    }

    /**
     * @param board  to see coordinate and ships.
     * @param row    in the coordinate.
     * @param col    in the coordinate.
     * @param player to show messages.
     * @param i      ship length.
     * @return true if it is free and
     * false if is not free.
     */
    private static boolean esColumnaAnteriorLibre(char[][] board, int row, int col, boolean player, int i) {
        if (row + i < 10) {
            if (board[row ][col - 1] == 'B') {
                if (player)
                    System.err.println("You can not put a ship attached to another.");
                return false;
            }
        }
        return true;
    }

    /**
     * @param board  to see coordinate and ships.
     * @param row    in the coordinate.
     * @param col    in the coordinate.
     * @param player to show messages.
     * @param i      ship length.
     * @return true if it is free and
     * false if is not free.
     */
    private static boolean esFilaAnteriorLibreOFilaSiguienteLibre(char[][] board, int row, int col, boolean player, int i) {
        if (col + i < 10) {
            if ((board[row - 1][col + i] == 'B') || (board[row + 1][col + i] == 'B')) {
                if (player)
                    System.err.println("You can not put a ship attached to another.");
                return false;

            }
        }
        return true;
    }

    /**
     * @param board  to see coordinate and ships.
     * @param row    in the coordinate.
     * @param col    in the coordinate.
     * @param player to show messages.
     * @param i      ship length.
     * @return true if it is free and
     * false if is not free.
     */
    private static boolean isFreePreviousRow(char[][] board, int row, int col, boolean player, int i) {

        if (board[row - 1][col] == 'B') {
            if (player)
                System.err.println("You can not put a ship attached to another.");
            return false;

        }
        return true;
    }

    /**
     * @param board  to see coordinate and ships.
     * @param row    in the coordinate
     * @param col    in the coordinate
     * @param player to show messages.
     * @param i      ship length.
     * @return true if it is free and
     * false if is not free.
     */
    private static boolean isFreeNextRow(char[][] board, int row, int col, boolean player, int i) {
        if ((col + i) < 10) {
            if ((board[row + 1][col + i] == 'B')) {
                if (player)
                    System.err.println("You can not put a ship attached to another.");
                return false;
            }
        }
        return true;
    }
}
