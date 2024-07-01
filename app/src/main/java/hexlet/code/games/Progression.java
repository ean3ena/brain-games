package hexlet.code.games;

import java.util.Scanner;
import hexlet.code.Engine;

public class Progression {

    public static void startGame(Scanner scanner, String userName) {

        // Выводим правила игры "Арифметическая прогрессия"
        System.out.println("What number is missing in the progression?");

        // Получаем количество попыток
        int attemptCount = Engine.getAttemptCount();

        // Если попытка успешная и попытки не закончились
        while (attemptCount > 0) {

            // Получаем случайное число в диапазоне от 1 до 50 - начало прогрессии
            final int min1 = 1;
            final int max1 = 50;
            int start = Engine.getRandomNumber(min1, max1);

            // Получаем случайное число в диапазоне от 1 до 5 - шаг прогрессии
            final int min2 = 1;
            final int max2 = 5;
            int step = Engine.getRandomNumber(min2, max2);

            // Получаем случайное число от 0 до 9 (длина прогрессии) - номер позиции спрятанного элемента
            final int min3 = 0;
            final int max3 = 10;
            int position = Engine.getRandomNumber(min3, max3);

            // Получаем ожидаемый ответ
            int expectedAnswer = calculateExpectedAnswer(start, step, position);

            // Формируем выражение для вопроса
            String expressionForQuestion = generateExpression(start, step, position);

            // Выводим вопрос игроку и предложение ввести ответ
            Engine.requestPlayerAnswer(expressionForQuestion);

            // Получаем ответ игрока
            int answer = scanner.nextInt();

            // Сравниваем ответ игрока с ожидаемым ответом
            boolean isPlayerAnswerCorrect = Engine.checkPlayerAnswer(userName, answer, expectedAnswer);

            // Если ответ неверный, то прекращаем игру
            if (!isPlayerAnswerCorrect) {
                break;
            }

            attemptCount--;
        }

        // Поздравляем с успешным окончанием игры
        if (attemptCount == 0) {
            Engine.showCongratulation(userName);
        }

    }

    public static int calculateExpectedAnswer(int start, int step, int position) {
        return start + step * position;
    }

    public static String generateExpression(int start, int step, int position) {

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
}
