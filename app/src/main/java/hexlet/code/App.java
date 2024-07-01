package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Выводим список игр с предложением выбрать игру
        String gameList = "Please enter the game number and press Enter.\n"
                        + "1 - Greet\n"
                        + "2 - Even\n"
                        + "3 - Calc\n"
                        + "4 - GCD\n"
                        + "5 - Progression\n"
                        + "0 - Exit\n"
                        + "Your choice: ";
        System.out.print(gameList);

        // Пользователь вводит номер игры
        int gameNumber = scanner.nextInt();

        // Номер игры должен быть из списка, кроме 0
        if (gameNumber > 0 && gameNumber < 6) {

            // Приветствуем игрока и возвращаем его имя
            String userName = Cli.greet(scanner);

            switch (gameNumber) {
                case 2:
                    // Игра "Проверка на чётность"
                    Even.startGame(scanner, userName);
                    break;
                case 3:
                    // Игра "Калькулятор"
                    Calc.startGame(scanner, userName);
                    break;
                case 4:
                    // Игра "НОД"
                    GCD.startGame(scanner, userName);
                    break;
                case 5:
                    // Игра "Арифметическая прогрессия"
                    Progression.startGame(scanner, userName);
                    break;
            }
        }

        scanner.close();
    }
}
