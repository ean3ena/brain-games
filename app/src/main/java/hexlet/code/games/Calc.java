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

            // Получаем номер случайной операции: "+", "-", "*"
            // Для этого сопоставим каждую операцию со случайным числом из соответствующего диапазона:
            // 0-30 - "+"
            // 31-60 - "-"
            // 61-100 - "*"
            int numberRandomOperation = Engine.getRandomNumber();

            // Получаем первое случайное число
            int firstRandomNumber = Engine.getRandomNumber();

            // Получаем второе случайное число
            int secondRandomNumber = Engine.getRandomNumber();

            String operationString = "";
            int expectedAnswer = 0;

            // Расчитываем ожидаемый ответ и строку операции по случайному числу
            if (numberRandomOperation >= 0 && numberRandomOperation <= 30) {
                // Операция "+"
                operationString = " + ";
                expectedAnswer = firstRandomNumber + secondRandomNumber;
            } else if (numberRandomOperation >= 31 && numberRandomOperation <= 60) {
                // Операция "-"
                operationString = " - ";
                expectedAnswer = firstRandomNumber - secondRandomNumber;
            } else if (numberRandomOperation >= 61 && numberRandomOperation <= 100) {
                // Операция "*"
                operationString = " * ";
                expectedAnswer = firstRandomNumber * secondRandomNumber;
            }

            // Выводим вопрос игроку
            Engine.showQuestion(firstRandomNumber + operationString + secondRandomNumber);

            // Выводим предложение игроку ввести свой ответ
            Engine.requestAnswer();

            // Получаем ответ игрока
            int answer = scanner.nextInt();

            // Сравниваем ответ игрока с ожидаемым ответом
            if (Engine.isCorrectAnswer(answer, expectedAnswer)) {
                Engine.notifyCorrectAnswer();
            } else {
                Engine.notifyWrongAnswer(answer, expectedAnswer, userName);
                break;
            }

            attemptCount--;
        }
        // Поздравляем с успешным окончанием игры
        Engine.showCongratulation(attemptCount, userName);

    }
}
