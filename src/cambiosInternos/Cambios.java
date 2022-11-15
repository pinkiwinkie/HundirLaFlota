package cambiosInternos;

public class Cambios {
    public static int separarCoordenadaNumero(String coordenada){
        char numero = coordenada.charAt(1);
        int aux=Character.getNumericValue(numero), numeroCoordenada = 0;
        if (aux>0&&aux<10)
            numeroCoordenada=aux;
        return numeroCoordenada;
    }

    public static int separarCoordenadaLetra(String coordenada){
        char letra = coordenada.charAt(0);
        int letraCoordenada = 0;
        if (letra>='A' && letra <='H')
            letraCoordenada =letra-64;
        return letraCoordenada;
    }

    public static boolean esLetraCorrecta(int letter){
        boolean esCorrecta = false;
        if (letter<65||letter>73)
            esCorrecta = true;
        return esCorrecta;
    }
//    public static boolean esNumeroCorrecto(int number){
//        boolean esCorrecto = false;
//        if (number)
//    }
}
