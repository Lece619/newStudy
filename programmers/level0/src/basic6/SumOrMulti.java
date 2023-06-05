package basic6;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SumOrMulti {
    public int solution(int[] num_list) {
        return num_list.length >= 11 ? Arrays.stream(num_list).sum() : Arrays.stream(num_list).reduce(1, (a, b) -> a * b);
    }

    public int[] solution(int start, int end) {
        return IntStream.rangeClosed(start, end).toArray();
    }
}
