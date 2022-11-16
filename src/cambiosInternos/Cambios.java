package cambiosInternos;

public class Cambios {
    public static int separarCoordenadaNumero(String coordenada) {
        char numero = coordenada.charAt(1);
        int numeroCoordenada;
        numeroCoordenada = Character.getNumericValue(numero);
        return numeroCoordenada;
    }

    public static int separarCoordenadaLetra(String coordenada) {
        char letra = coordenada.charAt(0);
        int letraCoordenada;
        letraCoordenada = letra - 64;
        return letraCoordenada;
    }

    public static boolean esLetraCorrecta(int letter) {
        boolean esCorrecta = false;
        if (letter > 0 && letter < 10)
            esCorrecta = true;
        return esCorrecta;
    }

    public static boolean esNumeroCorrecto(int number) {
        boolean esCorrecto = false;
        if (number > 0 && number < 10)
            esCorrecto = true;
        return esCorrecto;
    }
}
