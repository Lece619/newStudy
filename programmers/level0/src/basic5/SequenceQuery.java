package basic5;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SequenceQuery {
    public int[] solution(int[] arr, int[][] queries) {
        Arrays.stream(queries).forEach(query -> IntStream.rangeClosed(query[0], query[1]).forEach(i->arr[i] += 1));
        return arr;
    }
}
