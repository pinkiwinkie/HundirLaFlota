package logic;

public class Tablero {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void verTableroJugador(char[][] tablero, char[][] tableroDisparos) {
        System.out.println(ANSI_GREEN+"BOARD SHIPS\t\t\t\t BOARD SHOOTS"+ ANSI_RESET);
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.print("\t\t");
            for (int j = 0; j < tableroDisparos[0].length; j++) {
                System.out.print(tableroDisparos[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void verTableroPc(char[][] tableroPc, char[][] tableroDisparosPc) {
        System.out.println(ANSI_PURPLE+"BOARD SHIPS\t\t\t\t BOARD SHOOTS"+ ANSI_RESET);
        for (int i = 0; i < tableroPc.length; i++) {
            for (int j = 0; j < tableroPc[0].length; j++) {
                System.out.print(tableroPc[i][j] + " ");
            }
            System.out.print("\t\t");
            for (int j = 0; j < tableroDisparosPc[0].length; j++) {
                System.out.print(tableroDisparosPc[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static char[][] crearTablero() {
        char[][] tablero = new char[10][10];
        for (int i = 0; i < tablero.length; i++) {
            tablero[i][0] = (char) (64 + i);//letras
            for (int j = 0; j < tablero[i].length; j++) {
                if (j != 0) {
                    tablero[i][j] = '~';
                }
            }
            for (int j = 0; j < tablero[0].length; j++) {

                tablero[0][j] = (char) (48 + j);//números
            }
        }
        return tablero;
    }

    public static int contarCeldas (int [] barcos){
        int contador = 0; // este método lo uso para saber cuántas casillas ocupadas por barcos hay.
        for (int barco : barcos) { //con este método podemos saber las vidas de ambos jugadores.
            contador += barco;
        }
        return contador;
    }
}
