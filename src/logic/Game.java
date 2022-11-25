package logic;

import tools.Input;

import static logic.Ships.putOnTheBoard;
import static logic.Ships.thereIsACollision;
import static logic.Board.*;

public class Game {
    /**
     * initialize the variables needed to start playing.
     */
    private static void gameplay() {
        char [][] playerBoard = createBoard(), playerShootsBoard = createBoard(), pcBoard = createBoard(), pcShootsBoard = createBoard();
        int []ships={5,4,3,2,1};
        int pcLives= countCells(ships), PlayerLives = countCells(ships);
        showPlayerBoard(playerBoard, playerShootsBoard);
        showPcBoard(pcBoard, pcShootsBoard);
        Player.putShips(playerBoard, playerShootsBoard, ships);
        Pc.putShips(pcBoard,ships);
        showPcBoard(pcBoard,pcShootsBoard);
        do {
            boolean discountPcLives = Player.shoots(playerShootsBoard,pcBoard,playerBoard,pcShootsBoard),
                    discountPlayerLives = logic.Pc.shoots(pcShootsBoard,playerBoard,playerShootsBoard,pcBoard);
            if (discountPcLives && PlayerLives>0) {
                pcLives--;
                System.out.println(ANSI_PURPLE+"PC lives: "+pcLives+ ANSI_RESET);
                System.out.println(ANSI_GREEN+"Player lives: "+PlayerLives+ ANSI_RESET);
                System.out.println(ANSI_PURPLE+"PC lives: "+pcLives+ ANSI_RESET);
            }
            if (discountPlayerLives && pcLives>0) {
                PlayerLives--;
                System.out.println(ANSI_GREEN+"Player lives: "+PlayerLives+ ANSI_RESET);
            }
        }while (pcLives>0||PlayerLives>0);
    }

    /**
     * menu to start playing or leaving.
     */

    public static void menu(){
        boolean exit = false;
        int option;
        do {
            System.out.println("Hi, we are going to play to sink the fleet. You want to do?");
//            option = Input.getInt("1.Read the instructions.\n2.Play in easy mode.\n3.Play against AI.\n4.Exit.");
            option = Input.getInt("1.Play in easy mode.\n2.Exit.");
            switch (option){

                case 1:
                    gameplay();
                    break;
                case 2:
                    System.out.println("Bye.");
                    exit = true;
                default:
                    System.err.println("Introduce a valid option");
                    break;
            }
        } while (!exit);
    }
    public static void tutorial(){
        char [][] tableroJugador = createBoard(), tableroDisparosJugador = createBoard(), tableroPc = createBoard(), tableroDisparosPc = createBoard();
        int [] barcos = {5};
        System.out.println("Los jugadores empiezan con el tablero en blanco para posteriormente colocar los barcos.");
        showPlayerBoard(tableroJugador,tableroDisparosJugador);
        showPcBoard(tableroPc,tableroDisparosPc);
//        Jugador.colocarBarcos(tableroJugador,tableroDisparosJugador,barcos);
        boolean hayColision2 = thereIsACollision(tableroJugador, 4,8,4,1,true);
        if (!hayColision2)
            putOnTheBoard(tableroJugador,4,8,4,1);
        showPlayerBoard(tableroJugador,tableroDisparosJugador);
    }

//    private static void jugabilidadConIa() {
//        char [][] tableroJugador = crearTablero(), tableroDisparosJugador = crearTablero(), tableroPc = crearTablero(), tableroDisparosPc = crearTablero();
//        int []barcos={5,4,4,3,3,2,2,1,1};
//        int vidasPc=contarCeldas(barcos), vidasJugador = contarCeldas(barcos);
//        verTableroJugador(tableroJugador, tableroDisparosJugador);
//        verTableroPc(tableroPc, tableroDisparosPc);
//        Jugador.colocarBarcos(tableroJugador, tableroDisparosJugador, barcos);
//        Pc.colocarBarcos(tableroPc,barcos, tableroDisparosPc);
//        verTableroPc(tableroPc,tableroDisparosPc);
//        do {
//            boolean descuentaVidaPc = logic.Jugador.disparos(tableroDisparosJugador,tableroPc,tableroJugador,tableroDisparosPc),
//                    descuentaVidaJugador = logic.Pc.disparosConIa(tableroDisparosPc,tableroJugador,tableroDisparosJugador,tableroPc);
//            if (descuentaVidaPc && vidasJugador>0) {
//                vidasPc--;
//                System.out.println(ANSI_PURPLE+"Vidas PC: "+vidasPc+ ANSI_RESET);
//                System.out.println(ANSI_GREEN+"Vidas jugador: "+vidasJugador+ ANSI_RESET);
//                System.out.println(ANSI_PURPLE+"Vidas PC: "+vidasPc+ ANSI_RESET);
//            }if (descuentaVidaJugador && vidasPc>0) {
//                vidasJugador--;
//                System.out.println(ANSI_GREEN+"Vidas jugador: "+vidasJugador+ ANSI_RESET);
//            }
//        }while (vidasPc>0||vidasJugador>0);
//    }
}
