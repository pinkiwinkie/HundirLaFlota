import logic.Pc;

import static logic.Board.createBoard;
import static logic.Board.*;

public class Prueba {
    public static void main(String[] args) {
        char [][] tableroJugador = createBoard(),
                tableroDisparosJugador = createBoard(), tableroPc = createBoard(),
                tableroDisparosPc = createBoard();
        int [] barcos = {6,5,4,3,2,1};
        System.out.println("TABLERO JUGADOR \t\t\t DISPAROS JUGADOR");
        int vidasPc= countCells(barcos), vidasJugador = countCells(barcos);
        showPlayerBoard(tableroJugador, tableroDisparosJugador);
//        Jugador.colocarBarcos(tableroJugador, tableroDisparosJugador, barcos);


//        System.out.println("TABLERO JUGADOR \t\t\t DISPAROS JUGADOR");
//        verTablero(tableroJugador,tableroDisparosJugador);
//        logic.Jugador.pedirCoordenadas();
//        System.out.println(logic.Jugador.pedirOrientacion());
//        boolean hayColision2 = hayColision(tableroJugador, 4,8,4,1,true);
//        if (!hayColision2)

//        verTablero(tableroJugador,tableroDisparosJugador);
//        System.out.println(colisionHorizontal(tableroJugador,5,2,3,true,false));
//        System.out.println(colisionVertical(tableroJugador,5,2,3,true,false));
        Pc.putShips(tableroJugador,barcos);
       showPlayerBoard(tableroJugador,tableroDisparosJugador);
        Pc.putShips(tableroPc, barcos);
        showPcBoard(tableroPc,tableroDisparosPc);
//        Pc.disparosConIa(tableroDisparosPc,tableroJugador,tableroDisparosJugador,tableroPc);
//        do {
//            boolean descuentaVidaJugador = logic.Pc.disparos(tableroDisparosPc,tableroJugador,tableroDisparosJugador,tableroPc);
//            if (descuentaVidaJugador && vidasPc>0) {
//                vidasJugador--;
//                System.out.println(ANSI_GREEN+"Vidas jugador: "+vidasJugador+ ANSI_RESET);
//            }
//        }while (vidasJugador>0);
    }
}





//    boolean colisiona = false;
//    // he creado boolean jugador para mostrar los mensajes de error solo en la ronda del jugador.
//    int i = 0;
//        do {
//                i++;
//                if (orientacionBarco == 1) {
//                if (tablero[fila][columna] == '~') {
//                if (alrededorVerticalVacio(tablero, fila, columna, jugador, i)) {
//                if (alrededorHorizontalVacio(tablero, fila, columna, jugador, i))
//                return false;
//                } else
//                return true;
//                } else
//                return true;
//                } else {
//                if (tablero[fila][columna] == '~') {
//                if (alrededorHorizontalVacio(tablero, fila, columna, jugador, i)){
//                if(alrededorVerticalVacio(tablero, fila, columna, jugador, i))
//                return false;
//                } else {
//                return true;
//                }
//                } else {
//                return true;
//                }
//                }
//                } while (longitudBarco >= i);
//                return false;




/*
* public static boolean disparosJugador (char [][] disparosJugador, char [][] tableroPC, char [][] tableroJugador){
        Scanner sc = new Scanner(System.in);
        boolean resultado = false; // para que vaya descontando vidas.
        boolean disparos = false; //saber si has disparado.
        boolean salir = false; // solo se usa para salir del bucle si está correcto.
        do {
            char fila;
            int columna;
            String aux;
            System.out.println("Vamos a proceder a disparar");
            do {
                salir = false;
                System.out.println("Dime la fila (A-J) donde quieres disparar");
                fila = sc.nextLine().toUpperCase().charAt(0);
                if (fila < 'A' || fila > 'J'){
                    System.out.println("Introduce la letra de la A a la J");
                } else salir = true;
            }while (!salir);

            do {
                salir = false;
                System.out.println("Dime la columna (0-9) donde quieres disparar");
                aux = sc.nextLine();
                if (aux.compareTo("0") < 0 || aux.compareTo("9")>0 ) {
                    System.out.println("El valor introducido no es válido");
                } else salir = true;
            } while (!salir);
            columna = Integer.parseInt(aux);
            int posFila = fila - 'A' + 1; // esto es para que no cuente la columna de letras ni la fila de números.
            do {
                if (disparosJugador[posFila][columna + 1] == 'T' || disparosJugador[posFila][columna + 1] == 'X') {
                    System.out.println("Ya has disparado en esta coordenada");
                    salir = true;
                } else {
                    if (tableroPC[posFila][columna + 1] == 'B') {
                        tableroPC[posFila][columna + 1] = 'T';
                        disparosJugador[posFila][columna + 1] = 'T';
                        disparos = true;
                        resultado = true;
                        salir= false;
                    } else {
                        disparosJugador[posFila][columna + 1] = 'X';
                        tableroPC[posFila][columna + 1] = 'X';
                        disparos = true;
                    }
                }
            } while (!salir);
        } while (!disparos);
        System.out.println("Tablero jugador \t\t Tablero disparos jugador");
        VerTablero(tableroJugador, disparosJugador);
        return resultado;
    }
*
* */







// do {
//         if (disparosJugador[letraCoordFila][numeroCoordColumna] == 'T' || disparosJugador[letraCoordFila][numeroCoordColumna] == 'X') {
//         System.out.println("Ya has disparado en esta coordenada");
//         quedarse = true;
//         } else {
//         if (tableroPC[letraCoordFila][numeroCoordColumna] == 'B') {
//         tableroPC[letraCoordFila][numeroCoordColumna] = 'T';
//         disparosJugador[letraCoordFila][numeroCoordColumna] = 'T';
//         hayDisparo = true;
//         quedarse = false;
//         } else {
//         disparosJugador[letraCoordFila][numeroCoordColumna] = 'X';
//         tableroPC[letraCoordFila][numeroCoordColumna] = 'X';
//         hayDisparo = true;
//         }
//         }
//         } while (!quedarse);
//         verTableroJugador(tableroJugador, tableroPC);
//         return hayDisparo;





















