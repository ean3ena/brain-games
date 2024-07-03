package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static void interactionWithPlayer(Scanner scanner, String userName, String rules,
                                             String[] expressions, String[] expectedAnswers) {

        // Выводим правила игры
        System.out.println(rules);

        boolean isPlayerAnswerCorrect = true;

        // Если попытка успешная и попытки не закончились
        for (int i = 0; i < getAttemptCount(); i++) {

            // Выводим вопрос игроку и просим ввести ответ
            System.out.println("Question: " + expressions[i]);
            System.out.print("Your answer: ");

            // Получаем ответ игрока
            String answer = scanner.next();

            // Сравниваем ответ игрока с ожидаемым ответом
            // Если ответ неверный, то выводим сообщение и прекращаем игру
            if (answer.equals(expectedAnswers[i])) {
                System.out.println("Correct!");
            } else {
                String wrongAnswer = "'" + answer
                        + "' is wrong answer ;(. Correct answer was '"
                        + expectedAnswers[i] + "'.\n"
                        + "Let's try again, " + userName + "!";
                System.out.println(wrongAnswer);

                isPlayerAnswerCorrect = false;
                break;
            }
        }

        // Поздравляем с успешным окончанием игры
        if (isPlayerAnswerCorrect) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }

    public static String[] getNewEmptyArray() {
        return new String[getAttemptCount()];
    }

    public static int getAttemptCount() {
        final int attemptCount = 3;
        return attemptCount;
    }
}
