package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Even {
    public static void startGame() {

        String rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        String[][] questionsAndAnswers = new String[Engine.ATTEMPT_COUNT][2];

        for (int i = 0; i < questionsAndAnswers.length; i++) {
            int randomNumber = Util.getRandomNumber();
            questionsAndAnswers[i][0] = Integer.toString(randomNumber);
            questionsAndAnswers[i][1] = isEven(randomNumber) ? "yes" : "no";
        }
        Engine.interactionWithPlayer(rules, questionsAndAnswers);
    }

    private static boolean isEven(int randomNumber) {
        return randomNumber % 2 == 0;
    }
}
