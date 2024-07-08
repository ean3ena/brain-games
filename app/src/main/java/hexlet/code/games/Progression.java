package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Progression {

    public static void startGame() {

        // Правила игры "Арифметическая прогрессия"
        String rules = "What number is missing in the progression?";

        // Массив вопросов и ответов
        String[][] questionsAndAnswers = new String[Engine.ATTEMPT_COUNT][2];

        for (int i = 0; i < questionsAndAnswers.length; i++) {

            // Получаем случайное число в диапазоне от 1 до 50 - начало прогрессии
            final int minRangeStartProgression = 1;
            final int maxRangeStartProgression = 50;
            int start = Util.getRandomNumber(minRangeStartProgression, maxRangeStartProgression);

            // Получаем случайное число в диапазоне от 1 до 5 - шаг прогрессии
            final int minRangeStepProgression = 1;
            final int maxRangeStepProgression = 5;
            int step = Util.getRandomNumber(minRangeStepProgression, maxRangeStepProgression);

            // Получаем случайное число от 0 до 9 (длина прогрессии) - номер позиции спрятанного элемента
            final int minRangePosition = 0;
            final int maxRangePosition = 10;
            int position = Util.getRandomNumber(minRangePosition, maxRangePosition);

            // Заполняем массивы расчетными данными
            questionsAndAnswers[i][0] = getExpression(start, step, position);
            questionsAndAnswers[i][1] = getExpectedAnswer(start, step, position);
        }

        Engine.interactionWithPlayer(rules, questionsAndAnswers);
    }

    public static String getExpression(int start, int step, int position) {

        // Количество элементов в прогрессии - 10
        final int elementsCount = 10;

        String[] tmpArray = new String[elementsCount];

        for (int i = 0; i < elementsCount; i++) {

            if (i == position) {
                tmpArray[i] = "..";
            } else {
                tmpArray[i] = Integer.toString(start);
            }

            start += step;
        }

        return String.join(" ", tmpArray);
    }

    public static String getExpectedAnswer(int start, int step, int position) {
        int result = start + step * position;
        return Integer.toString(result);
    }
}
