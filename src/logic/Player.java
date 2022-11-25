package logic;

import static internalChanges.Changes.*;
import static logic.Ships.*;
import static logic.Board.*;

import tools.Input;

public class Player {
    /**
     * this method it is the functionality of fitting ships for the player.
     *
     * @param playerBoard       board to put the boats.
     * @param playerShootsBoard shooting board
     * @param ships             array with the boats to be placed.
     */
    public static void putShips(char[][] playerBoard, char[][] playerShootsBoard, int[] ships) {
        int ship, i = 0;
        boolean putIt;
        System.out.println("We are going to fit the ships");
        do {
            putIt = false;
            do {
                ship = ships[i];
                int orientation, coordinateNumberCol, coordinateLetterRow;
                String coordinate;
                System.out.println("Boat of " + ship + " cells.");
                coordinate = requestCoordinates();
                coordinateLetterRow = separateLetterCoordinate(coordinate);
                coordinateNumberCol = separateNumberCoordinate(coordinate);
                if (ship != 1)
                    orientation = requestOrientation();
                else
                    orientation = 2;
                if (!thereIsACollision(playerBoard, ship, coordinateLetterRow, coordinateNumberCol, orientation, true)) {
                    putOnTheBoard(playerBoard, ship, coordinateLetterRow, coordinateNumberCol, orientation);
                    putIt = true;
                    i++;
                }
                showPlayerBoard(playerBoard, playerShootsBoard);
            } while (!putIt);
        } while (i != ships.length);
    }

    /**
     * it is used to then put the ship and shoot at a coordinate.
     *
     * @return the coordinate of the board.
     */
    private static String requestCoordinates() {
        String coordinate;
        char firstPosition, secondPosition;
        boolean exitNumber, exitLetter, exitFormat;

        do {
            exitNumber = false;
            exitLetter = false;
            exitFormat = false;
            coordinate = Input.getString("Type coordinate: ");
            if (coordinate.length() != 2)
                System.err.println("Only two character.");
            else {
                firstPosition = coordinate.charAt(0);
                secondPosition = coordinate.charAt(1);
                if (!isCorrectLetter(separateLetterCoordinate(coordinate)))
                    System.err.println("Introduce a valid letter.");
                else
                    exitLetter = true;
                if (!isCorrectNumber(separateNumberCoordinate(coordinate)))
                    System.err.println("Introduce a valid number.");
                else
                    exitNumber = true;
                if ((firstPosition > 48 && firstPosition < 58) || (secondPosition > 64 && secondPosition < 74))
                    System.err.println("The format is incorrect.");
                else
                    exitFormat = true;
            }
        } while (!exitFormat || !exitLetter || !exitNumber);
        return coordinate;
    }

    /**
     * @return orientation of ships with length greater than 1.
     */
    private static int requestOrientation() {
        int orientation;
        boolean exit = false;
        do {
            orientation = Input.getInt("In which orientation do you want the ship? (1: horizontal, 2: vertical) ");
            if (!isCorrectOrientation(orientation))
                System.err.println("Introduce 1 or 2.");
            else
                exit = true;
        } while (!exit);
        return orientation;
    }

    /**
     * @param playerShootsBoard so that the user has control of the shots he has made.
     * @param pcBoard           board where the user shoots.
     * @param playerBoard       board where the user see his ships.
     * @param pcShootsBoard     to show it at the end of the whole.
     * @return true if discount Pc lives
     */
    public static boolean shoots(char[][] playerShootsBoard, char[][] pcBoard, char[][] playerBoard, char[][] pcShootsBoard) {
        boolean isShoot = false, exit, discountPcLives = false;
        String coordinate;
        System.out.println("Let's shoot.");
        do {
            int coordinateNumberCol, coordinateLetterRow;
            coordinate = requestCoordinates();
            coordinateLetterRow = separateLetterCoordinate(coordinate);
            coordinateNumberCol = separateNumberCoordinate(coordinate);
            //T: tocado, X: disparo fallido.
            exit = false;
            do {
                if (playerShootsBoard[coordinateLetterRow][coordinateNumberCol] == 'T' || playerShootsBoard[coordinateLetterRow][coordinateNumberCol] == 'X') {
                    System.err.println("You have already shoot at this coordinate.");
                    exit = true;
                } else {
                    if (pcBoard[coordinateLetterRow][coordinateNumberCol] == 'B') {
                        pcBoard[coordinateLetterRow][coordinateNumberCol] = 'T';
                        playerShootsBoard[coordinateLetterRow][coordinateNumberCol] = 'T';
                        discountPcLives = true;
                        if ((alrededorHorizontalVacio(pcBoard, coordinateLetterRow, coordinateNumberCol, false, 0)) &&
                                (alrededorVerticalVacio(pcBoard, coordinateLetterRow, coordinateNumberCol, false, 0)))
                            System.out.println("Barco tocado y hundido");
                        else
                            System.out.println("Barco tocado.");
                    } else {
                        playerShootsBoard[coordinateLetterRow][coordinateNumberCol] = 'X';
                        pcBoard[coordinateLetterRow][coordinateNumberCol] = 'X';
                    }
                    isShoot = true;
                }
            } while (!exit);
        } while (!isShoot);

        showPlayerBoard(playerBoard, playerShootsBoard);
        showPcBoard(pcBoard, pcShootsBoard);
        return discountPcLives;
    }

}
