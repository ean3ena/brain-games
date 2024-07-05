package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static final int ATTEMPT_COUNT = 3;

    public static void interactionWithPlayer(String rules, String[][] questionsAndAnswers) {

        Scanner scanner = new Scanner(System.in);

        String firstGreeting = """

                Welcome to the Brain Games!
                May I have your name?\s""";
        System.out.print(firstGreeting);

        String userName = scanner.next();

        System.out.println("Hello, " + userName + "!");

        // Выводим правила игры
        System.out.println(rules);

        boolean isPlayerAnswerCorrect = true;

        // Если попытка успешная и попытки не закончились
        for (int i = 0; i < ATTEMPT_COUNT; i++) {

            // Выводим вопрос игроку и просим ввести ответ
            System.out.println("Question: " + questionsAndAnswers[i][0]);
            System.out.print("Your answer: ");

            // Получаем ответ игрока
            String answer = scanner.next();

            // Сравниваем ответ игрока с ожидаемым ответом
            // Если ответ неверный, то выводим сообщение и прекращаем игру
            if (answer.equals(questionsAndAnswers[i][1])) {
                System.out.println("Correct!");
            } else {
                String wrongAnswer = "'" + answer
                        + "' is wrong answer ;(. Correct answer was '"
                        + questionsAndAnswers[i][1] + "'.\n"
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
}
