package service;

import model.Person;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomInput {

    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static byte byteInput(String massage) throws InputMismatchException {
        System.out.println(massage);
        byte input = scanner.nextByte();
        return input;

    }

    public static int intInput(String massage) throws InputMismatchException {

        System.out.print(massage + ": ");
        int input = scanner.nextInt();
        return input;

    }

    public static String stringInput(String massage) throws InputMismatchException {

        System.out.print(massage + ": ");
        String input = scanner.next();
        return input;

    }

     public static Object Date(String massage) throws InputMismatchException {

        System.out.print(massage + ": ");
        String input = scanner.toString();
        return input;

    }
}