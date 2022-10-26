package basic2;

import java.util.Arrays;

public class ArraysStreamTest {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        Arrays.stream(numbers).map(i -> i * 2).toArray();
    }
}
