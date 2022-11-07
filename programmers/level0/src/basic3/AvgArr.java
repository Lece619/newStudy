package basic3;

import java.util.ArrayList;
import java.util.Arrays;

public class AvgArr {
    public double solution(int[] numbers) {
//        return Arrays.stream(numbers).sum() / (double) numbers.length;
        return Arrays.stream(numbers).average().orElse(0);
    }
}
