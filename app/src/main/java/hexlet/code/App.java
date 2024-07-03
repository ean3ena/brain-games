package hexlet.code;

import java.util.Scanner;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;


public class App {

    public static void main(String[] args) {

        final int numberGameExit = 0;
        final int numberGameGreet = 1;
        final int numberGameEven = 2;
        final int numberGameCalc = 3;
        final int numberGameGcd = 4;
        final int numberGameProgression = 5;
        final int numberGamePrime = 6;

        // Выводим список игр с предложением выбрать игру
        String gameList = "Please enter the game number and press Enter.\n"
                + numberGameGreet + " - Greet\n"
                + numberGameEven + " - Even\n"
                + numberGameCalc + " - Calc\n"
                + numberGameGcd + " - GCD\n"
                + numberGameProgression + " - Progression\n"
                + numberGamePrime + " - Prime\n"
                + numberGameExit + " - Exit\n"
                + "Your choice: ";
        System.out.print(gameList);

        Scanner scanner = new Scanner(System.in);

        // Пользователь вводит номер игры
        int gameNumber = scanner.nextInt();

        // Номер игры должен быть из списка, не включая игру Exit
        if (gameNumber > numberGameExit && gameNumber <= numberGamePrime) {

            // Приветствуем игрока и возвращаем его имя
            String userName = Cli.greet(scanner);

            switch (gameNumber) {
                case numberGameEven:
                    // Игра "Проверка на чётность"
                    Even.startGame(scanner, userName);
                    break;
                case numberGameCalc:
                    // Игра "Калькулятор"
                    Calc.startGame(scanner, userName);
                    break;
                case numberGameGcd:
                    // Игра "НОД"
                    GCD.startGame(scanner, userName);
                    break;
                case numberGameProgression:
                    // Игра "Арифметическая прогрессия"
                    Progression.startGame(scanner, userName);
                    break;
                case numberGamePrime:
                    // Игра "Простое ли число?"
                    Prime.startGame(scanner, userName);
                default:
                    //
            }
        }
        scanner.close();

    }
}
