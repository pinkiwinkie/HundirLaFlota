import static cambiosInternos.Cambios.*;
import static logic.Tablero.*;

public class Game {
    public static void main(String[] args) {
        char [][] tableroJugador = crearTablero(),
                tableroDisparosJugador = crearTablero(),
                tableroPc = crearTablero(),
                tableroDisparosPc = crearTablero();

        System.out.println("JUGADOR \t\t\t DISPAROS JUGADOR");
        verTablero(tableroJugador, tableroDisparosJugador);
        System.out.println("\n\tPC \t\t\t\t\t DISPAROS PC");
        verTablero(tableroPc, tableroDisparosPc);

    }
}
