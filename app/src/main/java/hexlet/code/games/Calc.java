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
            String randomTypeOperation = getRandomTypeOperation(operations);

            questionsAndAnswers[i][0] = firstRandomNumber + " " + randomTypeOperation + " " + secondRandomNumber;
            questionsAndAnswers[i][1] = getExpectedAnswer(firstRandomNumber, secondRandomNumber, randomTypeOperation);
        }
        Engine.interactionWithPlayer(rules, questionsAndAnswers);
    }

    private static String getRandomTypeOperation(String[] operations) {
        int randomNumber = Util.getRandomNumber(0, operations.length);
        return operations[randomNumber];
    }

    private static String getExpectedAnswer(int firstNumber, int secondNumber, String typeOperation) {
        int result = switch (typeOperation) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            default -> 0;
        };
        return Integer.toString(result);
    }
}
