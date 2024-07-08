package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Prime {
    public static void startGame() {

        String rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        String[][] questionsAndAnswers = new String[Engine.ATTEMPT_COUNT][2];

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            int randomNumber = Util.getRandomNumber();
            questionsAndAnswers[i][0] = Integer.toString(randomNumber);
            questionsAndAnswers[i][1] = isPrime(randomNumber) ? "yes" : "no";
        }
        Engine.interactionWithPlayer(rules, questionsAndAnswers);
    }

    private static boolean isPrime(int randomNumber) {
        if (randomNumber < 2) {
            return false;
        }
        for (int i = 2; i <= Math.round(Math.sqrt(randomNumber)); i++) {
            if (randomNumber % i == 0) {
                return false;
            }
        }
        return true;
    }
}
