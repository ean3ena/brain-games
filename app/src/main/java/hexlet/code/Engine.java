package hexlet.code;

public class Engine {

    public static int getAttemptCount() {
        return 3; // количество попыток в игре
    }

    public static int getRandomNumber() {
        return (int)(Math.random() * 100);
    }

    public static void showQuestion(String expression) {
        System.out.println("Question: " + expression);
    }

    public static void showQuestion(int expression) {
        showQuestion(Integer.toString(expression));
    }

    public static void requestAnswer() {
        System.out.print("Your answer: ");
    }

    public static void notifyCorrectAnswer() {
        System.out.println("Correct!");
    }

    public static boolean isCorrectAnswer(String answer, String expectedAnswer) {
        return answer.equals(expectedAnswer);
    }

    public static boolean isCorrectAnswer(int answer, int expectedAnswer) {
        return answer == expectedAnswer;
    }

    public static void notifyWrongAnswer(String answer, String expectedAnswer, String userName) {
        String wrongAnswer = "'" + answer
                + "' is wrong answer ;(. Correct answer was '"
                + expectedAnswer + "'.\n"
                + "Let's try again, " + userName + "!";
        System.out.println(wrongAnswer);
    }

    public static void notifyWrongAnswer(int answer, int expectedAnswer, String userName) {
        notifyWrongAnswer(Integer.toString(answer), Integer.toString(expectedAnswer), userName);
    }

    public static void showCongratulation(int attemptCount, String userName) {
        if (attemptCount == 0) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
}
