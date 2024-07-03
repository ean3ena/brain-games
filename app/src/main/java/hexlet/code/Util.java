package hexlet.code;

public class Util {

    public static int getRandomNumber() {
        // Диапазон генерации случайных чисел по умолчанию
        final int MIN_RANGE = 0;
        final int MAX_RANGE = 100;

        return getRandomNumber(MIN_RANGE, MAX_RANGE);
    }

    public static int getRandomNumber(int min, int max) {
        return (int) (min + Math.random() * max);
    }

}
