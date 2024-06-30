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
            String expectedAnswer = randomNumber % 2 == 0 ? "yes" : "no";

            // Выводим вопрос игроку
            Engine.showQuestion(randomNumber);

            // Выводим предложение игроку ввести свой ответ
            Engine.requestAnswer();

            // Получаем ответ игрока
            String answer = scanner.next();

            // Сравниваем ответ игрока с ожидаемым ответом
            if (Engine.isCorrectAnswer(answer, expectedAnswer)) {
                Engine.notifyCorrectAnswer();
            } else {
                Engine.notifyWrongAnswer(answer, expectedAnswer, userName);
                break;
            }

            attemptCount--;
        }
        // Поздравляем с успешным окончанием игры
        Engine.showCongratulation(attemptCount, userName);

    }
}
