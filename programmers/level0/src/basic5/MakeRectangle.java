package basic5;

import java.util.stream.IntStream;

public class MakeRectangle {
    public int[][] solution(int[][] arr) {
        int maxLan = Math.max(arr.length, arr[0].length);
        int[][] answer = new int[maxLan][maxLan];
        IntStream.range(0, arr.length).forEach(i -> System.arraycopy(arr[i], 0, answer[i], 0, arr[0].length));
        return answer;
    }
}
