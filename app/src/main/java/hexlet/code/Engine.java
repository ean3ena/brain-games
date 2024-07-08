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
        System.out.println(rules);

        for (int i = 0; i < ATTEMPT_COUNT; i++) {

            System.out.println("Question: " + questionsAndAnswers[i][0]);
            System.out.print("Your answer: ");

            String answer = scanner.next();
            if (answer.equals(questionsAndAnswers[i][1])) {
                System.out.println("Correct!");
            } else {
                String wrongAnswer = "'" + answer
                        + "' is wrong answer ;(. Correct answer was '"
                        + questionsAndAnswers[i][1] + "'.\n"
                        + "Let's try again, " + userName + "!";
                System.out.println(wrongAnswer);
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
    }
}
