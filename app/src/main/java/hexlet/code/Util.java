package hexlet.code;

public class Util {

    public static int getRandomNumber() {
        // Диапазон генерации случайных чисел по умолчанию
        final int minRange = 0;
        final int maxRange = 100;

        return getRandomNumber(minRange, maxRange);
    }

    public static int getRandomNumber(int min, int max) {
        return (int) (min + Math.random() * max);
    }

}
