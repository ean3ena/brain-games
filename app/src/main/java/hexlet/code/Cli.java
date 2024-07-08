package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void greet() {
        Scanner scanner = new Scanner(System.in);

        String firstGreeting = """

                Welcome to the Brain Games!
                May I have your name?\s""";
        System.out.print(firstGreeting);
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
    }
}
