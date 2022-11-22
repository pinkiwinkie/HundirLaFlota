import tools.Input;
import static logic.Tablero.*;

public class Game {
    private static void jugabilidad() {
        char [][] tableroJugador = crearTablero(),
                tableroDisparosJugador = crearTablero(),
                tableroPc = crearTablero(),
                tableroDisparosPc = crearTablero();
        int[]barcos={3,3,3,3};
        int vidasPc=2, vidasJugador = 2;
        verTableroJugador(tableroJugador, tableroDisparosJugador);
        verTableroPc(tableroPc, tableroDisparosPc);
  Jugador.colocarBarcos(tableroJugador, tableroDisparosJugador, barcos);
//        Pc.colocarBarcos(tableroPc,barcos);
//        verTableroPc(tableroPc,tableroDisparosPc);
      /*2
       do {
            boolean prueba = Jugador.disparos(tableroDisparosJugador,tableroPc,tableroJugador);
            if (prueba)
                vidasPc--;
        }while (vidasPc>0);
*/
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
