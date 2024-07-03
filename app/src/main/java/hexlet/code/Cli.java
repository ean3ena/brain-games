package hexlet.code;

import java.util.Scanner;

public class Cli {

    public static String greet(Scanner scanner) {

        String firstGreeting = "\nWelcome to the Brain Games!\n"
                + "May I have your name? ";
        System.out.print(firstGreeting);

        String userName = scanner.next();

        System.out.println("Hello, " + userName + "!");

        return userName;
    }
}
