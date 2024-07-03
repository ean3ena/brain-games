package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;
import java.util.Scanner;

public class GCD {

    public static void startGame(Scanner scanner, String userName) {

        // Правила игры "НОД"
        String rules = "Find the greatest common divisor of given numbers.";

        // Массив выражений для вопроса игроку
        String[] expressions = Engine.getNewEmptyArray();
        // Массив ожидаемых от игрока ответов
        String[] expectedAnswers = Engine.getNewEmptyArray();

        for (int i = 0; i < expressions.length; i++) {

            // Получаем первое случайное число
            int firstRandomNumber = Util.getRandomNumber();

            // Получаем второе случайное число
            int secondRandomNumber = Util.getRandomNumber();

            // Заполняем массивы полученными значениями
            expressions[i] = getExpression(firstRandomNumber, secondRandomNumber);
            expectedAnswers[i] = getExpectedAnswer(firstRandomNumber, secondRandomNumber);
        }

        Engine.interactionWithPlayer(scanner, userName, rules, expressions, expectedAnswers);
    }

    public static String getExpression(int firstNumber, int secondNumber) {
        return firstNumber + " " + secondNumber;
    }

    public static String getExpectedAnswer(int firstNumber, int secondNumber) {

        // Алгоритм Евклида по нахождению НОД
        while (firstNumber != secondNumber) {
            if (firstNumber > secondNumber) {
                firstNumber -= secondNumber;
            } else {
                secondNumber -= firstNumber;
            }
        }

        return Integer.toString(firstNumber);
    }
}
