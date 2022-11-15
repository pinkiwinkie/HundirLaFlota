import static logic.Barcos.colocarEnElTablero;
import static logic.Tablero.crearTablero;
import static logic.Tablero.verTablero;
import static logic.Barcos.hayColision;

public class Prueba {
    public static void main(String[] args) {
        char [][] tableroJugador = crearTablero(),
                tableroDisparosJugador = crearTablero();
        System.out.println("TABLERO JUGADOR \t\t\t DISPAROS JUGADOR");
        verTablero(tableroJugador, tableroDisparosJugador);
        boolean hayColision = hayColision(tableroJugador,5,5,3,2,true);
        if (!hayColision)
            colocarEnElTablero(tableroJugador,5,5,3,2);
        verTablero(tableroJugador,tableroDisparosJugador);
    }
}
























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