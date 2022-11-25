package internalChanges;

/**
 * change the format of coordinates to make checks more convenient.
 */
public class Changes {
    /**
     * @param coordinate that is prompted of the user.
     * @return coordinate number.
     */
    public static int separateNumberCoordinate(String coordinate) {
        char number = coordinate.charAt(1);
        int numberCoordinate;
        numberCoordinate = Character.getNumericValue(number);
        return numberCoordinate;
    }

    /**
     * @param coordinate that is prompted of the user.
     * @return coordinate letter.
     */
    public static int separateLetterCoordinate(String coordinate) {
        char letter = coordinate.charAt(0);
        int letterCoordinate;
        letterCoordinate = letter - 64;
        return letterCoordinate;
    }

    /**
     * @param letter it is the return of the method of separating letter.
     * @return true if it is correct and false if is not correct.
     */
    public static boolean isCorrectLetter(int letter) {
        boolean isCorrect = false;
        if (letter > 0 && letter < 10)
            isCorrect = true;
        return isCorrect;
    }

    /**
     * @param number it is the return of the method of separating number.
     * @return true if it is correct and false if is not correct.
     */
    public static boolean isCorrectNumber(int number) {
        boolean isCorrect = false;
        if (number > 0 && number < 10)
            isCorrect = true;
        return isCorrect;
    }

    /**
     * @param number to comprobate the orientation.
     * @return true if it is correct and false if is not correct.
     */
    public static boolean isCorrectOrientation(int number) {
        boolean isCorrect = false;
        if (number == 1 || number == 2)
            isCorrect = true;
        return isCorrect;
    }
}
