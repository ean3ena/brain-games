package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Even {

    public static void startGame() {

        // Правила игры "Проверка на чётность"
        String rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        // Массив вопросов и ответов
        String[][] questionsAndAnswers = new String[Engine.ATTEMPT_COUNT][Engine.ATTEMPT_COUNT - 1];

        for (int i = 0; i < questionsAndAnswers.length; i++) {

            // Получаем случайное число для выражения
            int randomNumber = Util.getRandomNumber();

            // Заполняем массив полученными значениями
            questionsAndAnswers[i][0] = Integer.toString(randomNumber);
            questionsAndAnswers[i][1] = isEven(randomNumber) ? "yes" : "no";
        }

        Engine.interactionWithPlayer(rules, questionsAndAnswers);
    }

    public static boolean isEven(int randomNumber) {
        return randomNumber % 2 == 0;
    }
}
