import tools.Input;
import static logic.Tablero.*;

public class Game {
    private static void jugabilidad() {
        char [][] tableroJugador = crearTablero(),
                tableroDisparosJugador = crearTablero(),
                tableroPc = crearTablero(),
                tableroDisparosPc = crearTablero();
        int[]barcos={5,4,3,2,2,1,1};
        verTablero(tableroJugador, tableroDisparosJugador);
        verTablero(tableroPc, tableroDisparosPc);
        Jugador.colocarBarcos(tableroJugador, tableroDisparosJugador, barcos);
//        Pc.colocarBarcos(tableroPc,barcos);
        verTablero(tableroPc,tableroDisparosPc);
    }

    public static void menu(){
        boolean salir = false;
        int opcion;
        do {
            System.out.println("Hola, vamos a jugar a hundir la flota. Que quiere hacer?");
            opcion = Input.getInt("1.Leer las instrucciones.\n2.Jugar en modo facil.\n3.Jugar contra la IA");
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
                    System.out.println("Hasta luego");
                    salir = true;
            }
        } while (!salir);
    }
}
