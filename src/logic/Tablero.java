package logic;

public class Tablero {
    public static void verTablero(char[][] tablero, char[][] tableroDisparos) {
        System.out.println("TABLERO BARCOS\t\t\t\t TABLERO DISPAROS");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.print("\t\t");
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(tablero[i][j] + " ");
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
}
