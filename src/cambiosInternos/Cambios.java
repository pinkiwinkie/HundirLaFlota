package cambiosInternos;

public class Cambios {
    public static int separarCoordenadaNumero(String coordenada){
        char numero = coordenada.charAt(1);
        return Character.getNumericValue(numero);
    }

    public static int separarCoordenadaLetra(String coordenada){
        char letra = coordenada.charAt(0);
        int letraCoordenada = 0;
        for (int i = 65; i <73 ; i++) {
            if (letra==65)
                letraCoordenada =1;
            if (letra==66)
                letraCoordenada=2;
            if (letra==67)
                letraCoordenada=3;
            if (letra==68)
                letraCoordenada=4;
            if (letra==69)
                letraCoordenada=5;
            if (letra==70)
                letraCoordenada=6;
            if (letra==71)
                letraCoordenada=7;
            if (letra==72)
                letraCoordenada=8;
        }
        return letraCoordenada;
    }
}
