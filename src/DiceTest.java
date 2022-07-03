import java.util.Arrays;

public class DiceTest {
    public static void main(String[] args) {
        // Dice dice = new Dice();
        Dice dice = new Dice(20, 16, 16, 16, 16, 16);
        // Dice dice = new Dice(20, 30, 10, 0, 20, 20);
        int[] sides = new int[] { 0, 0, 0, 0, 0, 0 };

        int times = 1000000;
        for (int i = 0; i < times; i++) {
            int rolled = dice.roll();
            sides[rolled - 1]++;
        }

        double[] results = new double[6];
        for (int i = 0; i < 6; i++) {
            results[i] = (double) sides[i] / times * 100;
        }

        System.out.println(Arrays.toString(results));
    }
}
