package basic6;

import java.util.stream.IntStream;

public class DoubleArr {
    public int solution(int[][] arr) {
        return IntStream.range(0, arr.length).mapToLong(i -> {
            return IntStream.range(0, arr[i].length).filter(j -> arr[i][j] != arr[j][i]).count();
        }).sum() == 0 ? 1 : 0;
    }
}
