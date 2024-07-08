package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class GCD {
    public static void startGame() {

        String rules = "Find the greatest common divisor of given numbers.";

        String[][] questionsAndAnswers = new String[Engine.ATTEMPT_COUNT][2];

        final int min = 1;
        final int max = 100;

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            int firstRandomNumber = Util.getRandomNumber(min, max);
            int secondRandomNumber = Util.getRandomNumber(min, max);
            questionsAndAnswers[i][0] = firstRandomNumber + " " + secondRandomNumber;
            questionsAndAnswers[i][1] = getExpectedAnswer(firstRandomNumber, secondRandomNumber);
        }
        Engine.interactionWithPlayer(rules, questionsAndAnswers);
    }

    private static String getExpectedAnswer(int firstNumber, int secondNumber) {
        while (firstNumber != secondNumber) {
            if (firstNumber > secondNumber) {
                firstNumber -= secondNumber;
            } else {
                secondNumber -= firstNumber;
            }
        }
        return Integer.toString(firstNumber);
    }
}
