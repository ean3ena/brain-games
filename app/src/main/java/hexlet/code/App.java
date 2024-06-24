package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
                "Please enter the game number and press Enter.\n" +
                "1 - Greet\n" +
                "0 - Exit");
        System.out.print("Your choice: ");
        int gameNumber = scanner.nextInt();

        if (gameNumber != 0) {
            Cli.askName();
        }

        scanner.close();
    }
}
