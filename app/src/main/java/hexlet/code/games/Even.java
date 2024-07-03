package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;
import java.util.Scanner;

public class Even {

    public static void startGame(Scanner scanner, String userName) {

        // Правила игры "Проверка на чётность"
        String rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";

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
        return randomNumber % 2 == 0 ? "yes" : "no";
    }
}
