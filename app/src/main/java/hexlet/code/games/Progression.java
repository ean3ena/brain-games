package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;
import java.util.Scanner;

public class Progression {

    public static void startGame(Scanner scanner, String userName) {

        // Правила игры "Арифметическая прогрессия"
        String rules = "What number is missing in the progression?";

        // Массив выражений для вопроса игроку
        String[] expressions = Engine.getNewEmptyArray();
        // Массив ожидаемых от игрока ответов
        String[] expectedAnswers = Engine.getNewEmptyArray();

        for (int i = 0; i < expressions.length; i++) {

            // Получаем случайное число в диапазоне от 1 до 50 - начало прогрессии
            int minRangeStartProgression = 1;
            int maxRangeStartProgression = 50;
            int start = Util.getRandomNumber(minRangeStartProgression, maxRangeStartProgression);

            // Получаем случайное число в диапазоне от 1 до 5 - шаг прогрессии
            int minRangeStepProgression = 1;
            int maxRangeStepProgression = 5;
            int step = Util.getRandomNumber(minRangeStepProgression, maxRangeStepProgression);

            // Получаем случайное число от 0 до 9 (длина прогрессии) - номер позиции спрятанного элемента
            int minRangePosition = 0;
            int maxRangePosition = 10;
            int position = Util.getRandomNumber(minRangePosition, maxRangePosition);

            // Заполняем массивы расчетными данными
            expressions[i] = getExpression(start, step, position);
            expectedAnswers[i] = getExpectedAnswer(start, step, position);
        }

        Engine.interactionWithPlayer(scanner, userName, rules, expressions, expectedAnswers);
    }

    public static String getExpression(int start, int step, int position) {

        StringBuilder str = new StringBuilder();

        // Количество элементов в прогрессии - 10
        final int elementsCount = 10;
        for (int i = 0; i < elementsCount; i++) {

            if (i != 0) {
                str.append(" ");
            }

            if (i == position) {
                str.append("..");
            } else {
                str.append(start);
            }

            start += step;
        }

        return str.toString();
    }

    public static String getExpectedAnswer(int start, int step, int position) {
        int result = start + step * position;
        return Integer.toString(result);
    }
}
