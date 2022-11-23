import tools.Input;
import static logic.Tablero.*;

public class Game {

    private static void jugabilidad() {
        char [][] tableroJugador = crearTablero(),
                tableroDisparosJugador = crearTablero(),
                tableroPc = crearTablero(),
                tableroDisparosPc = crearTablero();
        int[]barcos={5,4,4,3,3,2,2,1,1};
        int vidasPc=contarCeldas(barcos), vidasJugador = contarCeldas(barcos);
        verTableroJugador(tableroJugador, tableroDisparosJugador);
        verTableroPc(tableroPc, tableroDisparosPc);
//        Jugador.colocarBarcos(tableroJugador, tableroDisparosJugador, barcos);
        Pc.colocarBarcos(tableroPc,barcos, tableroDisparosPc);
//        verTableroPc(tableroPc,tableroDisparosPc);
//        do {
//            boolean descuentaVidaPc = Jugador.disparos(tableroDisparosJugador,tableroPc,tableroJugador,tableroDisparosPc),
//                    descuentaVidaJugador = Pc.disparos(tableroDisparosPc,tableroJugador,tableroDisparosJugador,tableroPc);
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
    }

    public static void menu(){
        boolean salir = false;
        int opcion;
        do {
            System.out.println("Hi, we are going to play to sink the fleet. You want to do?");
            opcion = Input.getInt("1.Read the instructions.\n2.Play in easy mode.\n3.Play against AI");
            switch (opcion){
                case 1:
                    System.out.println();
                    break;
                case 2:
                    jugabilidad();
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Bye.");
                    salir = true;
                default:
                    System.err.println("Introduce a valid option");
                    break;
            }
        } while (!salir);
    }
}
