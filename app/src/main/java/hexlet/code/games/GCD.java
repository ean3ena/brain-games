package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class GCD {

    public static void startGame() {

        // Правила игры "НОД"
        String rules = "Find the greatest common divisor of given numbers.";

        // Массив вопросов и ответов
        String[][] questionsAndAnswers = new String[Engine.ATTEMPT_COUNT][Engine.ATTEMPT_COUNT - 1];

        final int minRange = 1;
        final int maxRange = 100;

        for (int i = 0; i < questionsAndAnswers.length; i++) {

            // Получаем первое случайное число
            int firstRandomNumber = Util.getRandomNumber(minRange, maxRange);

            // Получаем второе случайное число
            int secondRandomNumber = Util.getRandomNumber(minRange, maxRange);

            // Заполняем массивы полученными значениями
            questionsAndAnswers[i][0] = firstRandomNumber + " " + secondRandomNumber;
            questionsAndAnswers[i][1] = getExpectedAnswer(firstRandomNumber, secondRandomNumber);
        }

        Engine.interactionWithPlayer(rules, questionsAndAnswers);
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
