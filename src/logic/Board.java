package logic;

/**
 *
 */
public class Board {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";

    /**
     * @param board       to show it at the end of the whole.
     * @param shootsBoard to show it at the end of the whole.
     */
    public static void showPlayerBoard(char[][] board, char[][] shootsBoard) {
        System.out.println(ANSI_GREEN + "BOARD SHIPS\t\t\t\t BOARD SHOOTS" + ANSI_RESET);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\t\t");
            for (int j = 0; j < shootsBoard[0].length; j++) {
                System.out.print(shootsBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * @param board       to show it at the end of the whole.
     * @param ShootsBoard to show it at the end of the whole.
     */
    public static void showPcBoard(char[][] board, char[][] ShootsBoard) {
        System.out.println(ANSI_PURPLE + "BOARD SHIPS\t\t\t\t BOARD SHOOTS" + ANSI_RESET);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\t\t");
            for (int j = 0; j < ShootsBoard[0].length; j++) {
                System.out.print(ShootsBoard[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * @return the board to give you the gameplay.
     */
    public static char[][] createBoard() {
        char[][] board = new char[10][10];
        for (int i = 0; i < board.length; i++) {
            board[i][0] = (char) (64 + i);//letters
            for (int j = 0; j < board[i].length; j++) {
                if (j != 0) {
                    board[i][j] = '~';
                }
            }
            for (int j = 0; j < board[0].length; j++) {

                board[0][j] = (char) (48 + j);//numbers
            }
        }
        return board;
    }

    /**
     * I use this method to know how many boxes occupied by ships there are.
     * With this method we can know the lives of both players.
     *
     * @param ships array with the boats to be placed.
     * @return number of lives
     */
    public static int countCells(int[] ships) {
        int accountant = 0;
        for (int ship : ships) {
            accountant += ship;
        }
        return accountant;
    }
}
