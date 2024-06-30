package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Выводим список игр с предложением выбрать игру
        String gameList = "Please enter the game number and press Enter.\n"
                        + "1 - Greet\n"
                        + "2 - Even\n"
                        + "3 - Calc\n"
                        + "0 - Exit\n"
                        + "Your choice: ";
        System.out.print(gameList);

        // Пользователь вводит номер игры
        int gameNumber = scanner.nextInt();

        // Номер игры должен быть из списка, кроме 0
        if (gameNumber > 0 && gameNumber < 4) {

            // Приветствуем игрока и возвращаем его имя
            String userName = Cli.greet(scanner);

            if (gameNumber == 2) {
                // Игра "Проверка на чётность"
                Even.startGame(scanner, userName);
            } else if (gameNumber == 3) {
                // Игра "Калькулятор"
                Calc.startGame(scanner, userName);
            }
        }

        scanner.close();
    }
}
