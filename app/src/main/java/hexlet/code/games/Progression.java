package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Progression {
    public static void startGame() {

        String rules = "What number is missing in the progression?";

        String[][] questionsAndAnswers = new String[Engine.ATTEMPT_COUNT][2];

        for (int i = 0; i < questionsAndAnswers.length; i++) {

            final int elementsCount = 10;
            String[] progressionArray = new String[elementsCount];

            final int minRangeStartProgression = 1;
            final int maxRangeStartProgression = 50;
            int start = Util.getRandomNumber(minRangeStartProgression, maxRangeStartProgression);

            final int minRangeStepProgression = 1;
            final int maxRangeStepProgression = 5;
            int step = Util.getRandomNumber(minRangeStepProgression, maxRangeStepProgression);

            fillProgressionArray(progressionArray, start, step);

            final int minRangePosition = 0;
            final int maxRangePosition = 10;
            int position = Util.getRandomNumber(minRangePosition, maxRangePosition);

            questionsAndAnswers[i][1] = progressionArray[position];
            progressionArray[position] = "..";
            questionsAndAnswers[i][0] = String.join(" ", progressionArray);
        }
        Engine.interactionWithPlayer(rules, questionsAndAnswers);
    }

    private static void fillProgressionArray(String[] arr, int start, int step) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.toString(start);
            start += step;
        }
    }
}
