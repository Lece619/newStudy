package basic8;

import java.util.stream.IntStream;

public class MakeArr {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        IntStream.range(0, n).forEach(i -> answer[i][i] = 1);
        return answer;
    }
}
