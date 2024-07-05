package hexlet.code;

import java.util.Scanner;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;


public class App {

    public static void main(String[] args) {

        // Выводим список игр с предложением выбрать игру
        String gameList = """
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                Your choice:\s""";
        System.out.print(gameList);

        Scanner scanner = new Scanner(System.in);

        // Пользователь вводит номер игры
        String gameNumber = scanner.next();

        switch (gameNumber) {
            case "1" -> Cli.greet(); // Приветствие
            case "2" -> Even.startGame(); // Игра "Проверка на чётность"
            case "3" -> Calc.startGame(); // Игра "Калькулятор"
            case "4" -> GCD.startGame(); // Игра "НОД"
            case "5" -> Progression.startGame(); // Игра "Арифметическая прогрессия"
            case "6" -> Prime.startGame(); // Игра "Простое ли число?"
            default -> {
                // Exit
            }
        }
        scanner.close();
    }
}
