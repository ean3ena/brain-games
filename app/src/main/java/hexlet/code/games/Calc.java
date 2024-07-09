package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Calc {
    public static void startGame() {

        String rules = "What is the result of the expression?";

        String[][] questionsAndAnswers = new String[Engine.ATTEMPT_COUNT][2];
        String[] operations = new String[] {"+", "-", "*"};

        for (int i = 0; i < questionsAndAnswers.length; i++) {

            int firstRandomNumber = Util.getRandomNumber();
            int secondRandomNumber = Util.getRandomNumber();
            int randomOperationNumber = Util.getRandomNumber(0, operations.length);
            String randomTypeOperation = operations[randomOperationNumber];

            questionsAndAnswers[i][0] = firstRandomNumber + " " + randomTypeOperation + " " + secondRandomNumber;
            int expectedAnswer = getExpectedAnswer(firstRandomNumber, secondRandomNumber, randomTypeOperation);
            questionsAndAnswers[i][1] = String.valueOf(expectedAnswer);
        }
        Engine.interactionWithPlayer(rules, questionsAndAnswers);
    }

    private static int getExpectedAnswer(int firstNumber, int secondNumber, String typeOperation) {
        return switch (typeOperation) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            default -> 0;
        };
    }
}
