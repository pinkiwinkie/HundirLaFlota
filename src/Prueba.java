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


/*
* //HORIZONTAL
* if (fila == 1 && columna == 1) {
            if (tablero[fila][1 + columna + i] == 'B') {
                if (jugador)
                    System.out.println("No puedes poner un barco pegado de otro.");
                return false;
            }
        } else if (fila == 9 && columna == 1) {
            if (tablero[fila][1 + columna + i] == 'B') {
                if (jugador)
                    System.out.println("No puedes poner un barco pegado de otro.");
                return false;
            }
        } else if (fila == 1 && columna == 9) {
            if (tablero[1 + fila][columna] == 'B') {
                if (jugador)
                    System.out.println("No puedes poner un barco pegado de otro.");
                return false;
            }
        } else {
            if ((tablero[fila][--columna + i] == 'B') || (tablero[fila][2 + columna + i] == 'B')) {
                if (jugador)
                    System.out.println("No puedes poner un barco pegado de otro.");
                return false;
            }
        }
*
*
* //VERTICAL
*  if (fila == 1 && columna == 1) {
            if (tablero[1 + fila + i][columna] == 'B') {
                if (jugador)
                    System.out.println("No puedes poner un barco pegado de otro.");
                return false;
            }
        } else if (fila == 9 && columna == 1) {
            if (tablero[--fila + i][columna] == 'B') {
                if (jugador)
                    System.out.println("No puedes poner un barco pegado de otro.");
                return false;
            }
        } else if (fila == 1 && columna == 9) {
            if (tablero[1 + fila + i][columna] == 'B') {
                if (jugador)
                    System.out.println("No puedes poner un barco pegado de otro.");
                return false;
            }
        } else {
            if ((tablero[--fila + i][columna] == 'B') || (tablero[2 + fila + i][columna] == 'B')) {
                if (jugador)
                    System.out.println("No puedes poner un barco pegado de otro.");
                return false;
            }
        }
*
* */





















/*
*
* public static void colocarBarcosJugador(char [][] tableroJugador, char[][] disparosJugador, int [] barcos){
        Scanner sc = new Scanner(System.in);

        int barco;
        boolean colocado = false;
        boolean salir = false; //para que no salga del bucle hasta que no se haya introducido lo correcto.
        for (int i = 0; i < barcos.length; i++) {
            do {
                barco=barcos[i];
                char fila;
                int columna;
                int posicion;
                String aux;
                System.out.println("Vamos a colocar el barco de " + barco + " celdas.");
                do {
                    salir = false;
                    System.out.println("Dime la fila (A-J) donde lo quieres colocar");
                    fila = sc.nextLine().toUpperCase().charAt(0);
                    if (fila < 'A' || fila > 'J'){
                        System.out.println("Introduce la letra de la A a la J");
                    } else
                        salir = true;
                }while (!salir);

                do {
                    salir = false;
                    System.out.println("Dime la columna (0-9) donde lo quieres colocar");
                    //columna = sc.nextInt();
                    aux=sc.nextLine();
                    if (aux.compareTo("0") < 0 || aux.compareTo("9") >0 ) {
                        System.out.println("El valor introducido no es válido");
                    } else salir = true;
                    columna=Integer.parseInt(aux);
                } while (!salir);

                do {
                    salir = false;
                    System.out.println("Dime la posición: 1-Horizontal o 2-Vertical");
                    posicion = sc.nextInt();
                    sc.nextLine();
                    if (posicion < 1 || posicion > 2){
                        System.out.println("Introduce 1 o 2.");
                    } else salir = true;
                } while (!salir);

                int posFila = fila - 'A' + 1;
                int posCol = columna  + 1;
                if (!hayColision(tableroJugador, barco, posFila, posCol, posicion, true)) {
                    colocarBarco(tableroJugador, barco, posCol, posicion, posFila);
                    colocado=true;
                }
                else {
                    colocado = false;
                }
                VerTablero(tableroJugador, disparosJugador);
            } while (!colocado);
        }
    }
* */