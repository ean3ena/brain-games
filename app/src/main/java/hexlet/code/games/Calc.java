package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class Calc {

    public static void startGame() {

        // Правила игры "Калькулятор"
        String rules = "What is the result of the expression?";

        // Массив вопросов и ответов
        String[][] questionsAndAnswers = new String[Engine.ATTEMPT_COUNT][Engine.ATTEMPT_COUNT - 1];

        for (int i = 0; i < questionsAndAnswers.length; i++) {

            // Получаем первое случайное число для выражения
            int firstRandomNumber = Util.getRandomNumber();

            // Получаем второе случайное число для выражения
            int secondRandomNumber = Util.getRandomNumber();

            // Получаем случайный тип операции
            String randomTypeOperation = getRandomTypeOperation();

            // Заполняем массив полученными значениями
            questionsAndAnswers[i][0] = firstRandomNumber + randomTypeOperation + secondRandomNumber;
            questionsAndAnswers[i][1] = getExpectedAnswer(firstRandomNumber, secondRandomNumber, randomTypeOperation);
        }

        Engine.interactionWithPlayer(rules, questionsAndAnswers);
    }

    public static String getRandomTypeOperation() {

        // Получаем случайное число для определения типа операции: "+", "-", "*"
        // Для этого сопоставим тип операции с соответствующими диапазонами случайных чисел:
        // 0-30 - "+"
        // 31-60 - "-"
        // 61-100 - "*"
        final int minRangeAddition = 0;
        final int maxRangeAddition = 30;
        final int minRangeSubstraction = 31;
        final int maxRangeSubstraction = 60;
        final int minRangeMultiplication = 61;
        final int maxRangeMultiplication = 100;

        int randomNumber = Util.getRandomNumber();

        String typeOperation = "";

        if (randomNumber >= minRangeAddition && randomNumber <= maxRangeAddition) {
            // Операция "+"
            typeOperation = " + ";
        } else if (randomNumber >= minRangeSubstraction && randomNumber <= maxRangeSubstraction) {
            // Операция "-"
            typeOperation = " - ";
        } else if (randomNumber >= minRangeMultiplication && randomNumber <= maxRangeMultiplication) {
            // Операция "*"
            typeOperation = " * ";
        }
        return typeOperation;
    }

    public static String getExpectedAnswer(int firstNumber, int secondNumber, String typeOperation) {

        int result = switch (typeOperation) {
            case " + " -> firstNumber + secondNumber;
            case " - " -> firstNumber - secondNumber;
            case " * " -> firstNumber * secondNumber;
            default -> 0;
        };

        return Integer.toString(result);
    }
}
