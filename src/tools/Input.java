package tools;

import java.util.Scanner;

public class Input {
    public static int getInt(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        while(!sc.hasNextInt()){
            System.err.println("Error - An integer number is requested");
            sc.next();
        }
        return sc.nextInt();
    }

    public static String getString(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.next();
    }

    public static char getChar(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.next().charAt(0);
    }
}
