package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Prime {

    public static void startGame() {

        // Правила игры "Простое ли число?"
        String rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        // Массив вопросов и ответов
        String[][] questionsAndAnswers = new String[Engine.ATTEMPT_COUNT][Engine.ATTEMPT_COUNT - 1];

        for (int i = 0; i < questionsAndAnswers.length; i++) {

            // Получаем случайное число для выражения
            int randomNumber = Util.getRandomNumber();

            // Заполняем массивы расчетными данными
            questionsAndAnswers[i][0] = Integer.toString(randomNumber);
            questionsAndAnswers[i][1] = isPrime(randomNumber) ? "yes" : "no";
        }

        Engine.interactionWithPlayer(rules, questionsAndAnswers);
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
