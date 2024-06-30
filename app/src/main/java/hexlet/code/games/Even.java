package hexlet.code.games;

import java.util.Scanner;
import hexlet.code.Engine;

public class Even {

    public static void startGame(Scanner scanner, String userName) {

        // Выводим правила игры "Проверка на чётность"
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

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
        return randomNumber % 2 == 0 ? "yes" : "no";
    }
}
