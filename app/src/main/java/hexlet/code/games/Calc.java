package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;
import java.util.Scanner;

public class Calc {

    public static void startGame(Scanner scanner, String userName) {

        // Правила игры "Калькулятор"
        String rules = "What is the result of the expression?";

        // Массив выражений для вопроса игроку
        String[] expressions = Engine.getNewEmptyArray();
        // Массив ожидаемых от игрока ответов
        String[] expectedAnswers = Engine.getNewEmptyArray();

        for (int i = 0; i < expressions.length; i++) {

            // Получаем первое случайное число для выражения
            int firstRandomNumber = Util.getRandomNumber();

            // Получаем второе случайное число для выражения
            int secondRandomNumber = Util.getRandomNumber();

            // Получаем случайный тип операции
            String randomTypeOperation = getRandomTypeOperation();

            // Заполняем массивы полученными значениями
            expressions[i] = getExpression(firstRandomNumber, secondRandomNumber, randomTypeOperation);
            expectedAnswers[i] = getExpectedAnswer(firstRandomNumber, secondRandomNumber, randomTypeOperation);
        }

        Engine.interactionWithPlayer(scanner, userName, rules, expressions, expectedAnswers);
    }

    public static String getRandomTypeOperation() {

        // Получаем случайное число для определения типа операции: "+", "-", "*"
        // Для этого сопоставим тип операции с соответствующими диапазонами случайных чисел:
        // 0-30 - "+"
        // 31-60 - "-"
        // 61-100 - "*"
        final int MIN_RANGE_ADDITION = 0;
        final int MAX_RANGE_ADDITION = 30;
        final int MIN_RANGE_SUBTRACTION = 31;
        final int MAX_RANGE_SUBTRACTION = 60;
        final int MIN_RANGE_MULTIPLICATION = 61;
        final int MAX_RANGE_MULTIPLICATION = 100;

        int randomNumber = Util.getRandomNumber();

        String typeOperation = "";

        if (randomNumber >= MIN_RANGE_ADDITION && randomNumber <= MAX_RANGE_ADDITION) {
            // Операция "+"
            typeOperation = " + ";
        } else if (randomNumber >= MIN_RANGE_SUBTRACTION && randomNumber <= MAX_RANGE_SUBTRACTION) {
            // Операция "-"
            typeOperation = " - ";
        } else if (randomNumber >= MIN_RANGE_MULTIPLICATION && randomNumber <= MAX_RANGE_MULTIPLICATION) {
            // Операция "*"
            typeOperation = " * ";
        }
        return typeOperation;
    }

    public static String getExpression(int firstNumber, int secondNumber, String typeOperation) {
        return firstNumber + typeOperation + secondNumber;
    }

    public static String getExpectedAnswer(int firstNumber, int secondNumber, String typeOperation) {

        int result = 0;

        switch (typeOperation) {
            case " + ":
                result = firstNumber + secondNumber;
                break;
            case " - ":
                result = firstNumber - secondNumber;
                break;
            case " * ":
                result = firstNumber * secondNumber;
                break;
        }

        return Integer.toString(result);
    }
}
