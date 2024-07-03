package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;
import java.util.Scanner;

public class Prime {

    public static void startGame(Scanner scanner, String userName) {

        // Правила игры "Простое ли число?"
        String rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        // Массив выражений для вопроса игроку
        String[] expressions = Engine.getNewEmptyArray();
        // Массив ожидаемых от игрока ответов
        String[] expectedAnswers = Engine.getNewEmptyArray();

        for (int i = 0; i < expressions.length; i++) {

            // Получаем случайное число для выражения
            int randomNumber = Util.getRandomNumber();

            // Заполняем массивы расчетными данными
            expressions[i] = getExpression(randomNumber);
            expectedAnswers[i] = getExpectedAnswer(randomNumber);
        }

        Engine.interactionWithPlayer(scanner, userName, rules, expressions, expectedAnswers);
    }

    public static String getExpression(int number) {
        return Integer.toString(number);
    }

    public static String getExpectedAnswer(int randomNumber) {
        return isPrime(randomNumber) ? "yes" : "no";
    }

    public static boolean isPrime(int randomNumber) {

        if (randomNumber % 2 == 0) {
            return randomNumber == 2;
        }

        final int nextDivisor = 3;
        for (int i = nextDivisor; i < Math.round(Math.sqrt(randomNumber)) + 1; i += 2) {
            if (randomNumber % i == 0) {
                return false;
            }
        }
        return true;
    }
}
