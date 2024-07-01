package hexlet.code.games;

import java.util.Scanner;
import hexlet.code.Engine;

public class GCD {

    public static void startGame(Scanner scanner, String userName) {

        // Выводим правила игры "НОД"
        System.out.println("Find the greatest common divisor of given numbers.");

        // Получаем количество попыток
        int attemptCount = Engine.getAttemptCount();

        // Если попытка успешная и попытки не закончились
        while (attemptCount > 0) {

            // Диапазон генерации чисел (уменьшен для простоты вычислений)
            int min = 1;
            int max = 50;

            // Получаем первое случайное число
            int firstRandomNumber = Engine.getRandomNumber(min, max);

            // Получаем второе случайное число
            int secondRandomNumber = Engine.getRandomNumber(min, max);

            // Получаем ожидаемый ответ
            int expectedAnswer = calculateGCD(firstRandomNumber, secondRandomNumber);

            // Выводим вопрос игроку и предложение ввести ответ
            String expressionForQuestion = firstRandomNumber + " " + secondRandomNumber;
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

    public static int calculateGCD(int firstNumber, int secondNumber) {

        // Алгоритм Евклида по нахождению НОД
        while (firstNumber != secondNumber) {
            if (firstNumber > secondNumber) {
                firstNumber -= secondNumber;
            } else {
                secondNumber -= firstNumber;
            }
        }

        return firstNumber;
    }
}
