package hexlet.code;

import java.util.Scanner;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;


public class App {

    public static void main(String[] args) {

        final int GAME_EXIT_NUMBER = 0;
        final int GAME_GREET_NUMBER = 1;
        final int GAME_EVEN_NUMBER = 2;
        final int GAME_CALC_NUMBER = 3;
        final int GAME_GCD_NUMBER = 4;
        final int GAME_PROGRESSION_NUMBER = 5;
        final int GAME_PRIME_NUMBER = 6;

        // Выводим список игр с предложением выбрать игру
        String gameList = "Please enter the game number and press Enter.\n"
                + GAME_GREET_NUMBER + " - Greet\n"
                + GAME_EVEN_NUMBER + " - Even\n"
                + GAME_CALC_NUMBER + " - Calc\n"
                + GAME_GCD_NUMBER + " - GCD\n"
                + GAME_PROGRESSION_NUMBER + " - Progression\n"
                + GAME_PRIME_NUMBER + " - Prime\n"
                + GAME_EXIT_NUMBER + " - Exit\n"
                + "Your choice: ";
        System.out.print(gameList);

        Scanner scanner = new Scanner(System.in);

        // Пользователь вводит номер игры
        int gameNumber = scanner.nextInt();

        // Номер игры должен быть из списка, не включая игру Exit
        if (gameNumber > GAME_EXIT_NUMBER && gameNumber <= GAME_PRIME_NUMBER) {

            // Приветствуем игрока и возвращаем его имя
            String userName = Cli.greet(scanner);

            switch (gameNumber) {
                case GAME_EVEN_NUMBER:
                    // Игра "Проверка на чётность"
                    Even.startGame(scanner, userName);
                    break;
                case GAME_CALC_NUMBER:
                    // Игра "Калькулятор"
                    Calc.startGame(scanner, userName);
                    break;
                case GAME_GCD_NUMBER:
                    // Игра "НОД"
                    GCD.startGame(scanner, userName);
                    break;
                case GAME_PROGRESSION_NUMBER:
                    // Игра "Арифметическая прогрессия"
                    Progression.startGame(scanner, userName);
                    break;
                case GAME_PRIME_NUMBER:
                    // Игра "Простое ли число?"
                    Prime.startGame(scanner, userName);
            }
        }
        scanner.close();

    }
}
