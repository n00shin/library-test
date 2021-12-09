package service;

import java.util.InputMismatchException;

public class Exit {

    public static String exit() throws IllegalArgumentException, InputMismatchException {

        byte exit;
        String terminate;
        exit = CustomInput.byteInput("do you want to exit ?\n 1.yes \n 2.no");
        switch (exit) {
            case 1:
                terminate = "yes";
                return terminate;
            case 2:
                terminate = "no";
                return terminate;
            default:
                System.out.println("you enter wrong number\nyou get out!");
                terminate = "no";
                return terminate;
        }

    }
}
