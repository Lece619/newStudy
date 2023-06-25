package basic7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class AddArr {
    public int[] solution(int[] arr) {
        List<Integer> nums = new ArrayList<>();
        Arrays.stream(arr).forEach(i -> IntStream.range(0, i).forEach(num -> nums.add(i)));
        return nums.stream().mapToInt(i -> i).toArray();
    }
}
