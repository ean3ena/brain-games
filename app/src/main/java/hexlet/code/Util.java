package hexlet.code;

public class Util {
    public static int getRandomNumber() {
        final int min = 0;
        final int max = 100;
        return getRandomNumber(min, max);
    }

    public static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }
}
