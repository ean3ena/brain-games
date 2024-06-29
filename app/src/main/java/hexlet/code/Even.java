package hexlet.code;

import java.util.Scanner;

public class Even {

    public static void startGame(Scanner scanner, String userName) {

        // Правила игры
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int attemptCount = 3; // всего 3 попытки

        // Если попытка успешная и попытки не закончились
        while (attemptCount > 0) {

            // Получаем и выводим случайное число
            int randomNumber = (int)(Math.random() * 100);
            System.out.println("Question: " + randomNumber);

            // Ожидаемый ответ
            String expectedAnswer = randomNumber % 2 == 0 ? "yes" : "no";

            // Предложение игроку ввести свой ответ
            System.out.print("Your answer: ");
            String answer = scanner.next();

            // Сравнение ответа игрока с ожидаемым ответом
            if (answer.equals(expectedAnswer)) {
                System.out.println("Correct!");
            } else {
                String wrongAnswer = "'" + answer
                                    + "' is wrong answer ;(. Correct answer was '"
                                    + expectedAnswer + "'.\n"
                                    + "Let's try again, " + userName + "!";
                System.out.println(wrongAnswer);
                break;
            }

            attemptCount--;
        }

        if (attemptCount == 0) {
            System.out.println("Congratulations, " + userName + "!");
        }

    }
}
