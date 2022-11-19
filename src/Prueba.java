import static logic.Barcos.*;
import static logic.Tablero.crearTablero;
import static logic.Tablero.verTablero;

public class Prueba {
    public static void main(String[] args) {
        char [][] tableroJugador = crearTablero(),
                tableroDisparosJugador = crearTablero();
        int [] barcos = {4,3,2,1,1};
        System.out.println("TABLERO JUGADOR \t\t\t DISPAROS JUGADOR");
        verTablero(tableroJugador, tableroDisparosJugador);
        Jugador.colocarBarcos(tableroJugador, tableroDisparosJugador, barcos);
//        System.out.println("TABLERO JUGADOR \t\t\t DISPAROS JUGADOR");
//        verTablero(tableroJugador,tableroDisparosJugador);
//        Jugador.pedirCoordenadas();
//        System.out.println(Jugador.pedirOrientacion());
//        boolean hayColision2 = hayColision(tableroJugador, 4,8,4,1,true);
//        if (!hayColision2)
//            colocarEnElTablero(tableroJugador,4,8,4,1);
//        verTablero(tableroJugador,tableroDisparosJugador);
//        System.out.println(colisionHorizontal(tableroJugador,5,2,3,true,false));
//        System.out.println(colisionVertical(tableroJugador,5,2,3,true,false));
    }
}