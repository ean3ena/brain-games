package hexlet.code.games;

import java.util.Scanner;
import hexlet.code.Engine;

public class Prime {

    public static void startGame(Scanner scanner, String userName) {

        // Выводим правила игры "Простое ли число?"
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        int attemptCount = Engine.getAttemptCount();

        // Если попытка успешная и попытки не закончились
        while (attemptCount > 0) {

            // Получаем случайное число
            int randomNumber = Engine.getRandomNumber();

            // Расчитываем ожидаемый ответ
            String expectedAnswer = getExpectedAnswer(randomNumber);

            // Выводим вопрос игроку и предложение ввести ответ
            Engine.requestPlayerAnswer(randomNumber);

            // Получаем ответ игрока
            String answer = scanner.next();

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

    public static String getExpectedAnswer(int randomNumber) {
        return isPrime(randomNumber) ? "yes" : "no";
    }

    public static boolean isPrime(int randomNumber) {

        if (randomNumber % 2 == 0) {
            return randomNumber == 2;
        }

        for (int i = 3; i < Math.round(Math.sqrt(randomNumber)) + 1; i += 2) {
            if (randomNumber % i == 0) {
                return false;
            }
        }
        return true;
    }
}
