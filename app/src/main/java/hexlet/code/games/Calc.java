package hexlet.code.games;

import java.util.Scanner;
import hexlet.code.Engine;

public class Calc {

    public static void startGame(Scanner scanner, String userName) {

        // Выводим правила игры "Калькулятор"
        System.out.println("What is the result of the expression?");

        // Получаем количество попыток
        int attemptCount = Engine.getAttemptCount();

        // Если попытка успешная и попытки не закончились
        while (attemptCount > 0) {

            // Получаем первое случайное число
            int firstRandomNumber = Engine.getRandomNumber();

            // Получаем второе случайное число
            int secondRandomNumber = Engine.getRandomNumber();

            // Расчитываем тип операции по случайному числу
            String randomTypeOperation = getRandomTypeOperation();

            // Расчитываем ожидаемый ответ
            int expectedAnswer = calculateByTypeOperation(firstRandomNumber, secondRandomNumber,randomTypeOperation);

            // Выводим игроку вопрос и предложение ввести ответ
            String expressionForQuestion = firstRandomNumber + randomTypeOperation + secondRandomNumber;
            Engine.requestPlayerAnswer(expressionForQuestion);

            // Получаем ответ игрока
            int answer = scanner.nextInt();

            // Сравниваем ответ игрока с ожидаемым ответом
            boolean isPlayerAnswerCorrect = Engine.checkPlayerAnswer(userName, answer, expectedAnswer);

            // Если ответ неверный, то прекращаем игру
            if (!isPlayerAnswerCorrect) {
                break;
            }

            attemptCount--;
        }

        // Если все попытки успешные, то поздравляем с успешным окончанием игры
        if (attemptCount == 0) {
            Engine.showCongratulation(userName);
        }

    }

    public static String getRandomTypeOperation() {

        // Получаем случайное число для определения типа операции: "+", "-", "*"
        // Для этого сопоставим тип операции с соответствующими диапазонами случайных чисел:
        // 0-30 - "+"
        // 31-60 - "-"
        // 61-100 - "*"
        int randomNumber = Engine.getRandomNumber();

        String typeOperation = "";

        if (randomNumber >= 0 && randomNumber <= 30) {
            // Операция "+"
            typeOperation = " + ";
        } else if (randomNumber >= 31 && randomNumber <= 60) {
            // Операция "-"
            typeOperation = " - ";
        } else if (randomNumber >= 61 && randomNumber <= 100) {
            // Операция "*"
            typeOperation = " * ";
        }
        return typeOperation;
    }

    public static int calculateByTypeOperation(int firstNumber, int secondNumber, String operation) {

        switch (operation) {
            case " + ":
                return firstNumber + secondNumber;
            case " - ":
                return firstNumber - secondNumber;
            case " * ":
                return firstNumber * secondNumber;
            default:
                return 0;
        }
    }
}
