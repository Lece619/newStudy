package basic3;

import java.util.stream.IntStream;

public class MakeDimensionTwo {

    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length/n][n];
        IntStream.range(0, num_list.length).forEach(i->
            answer[i / n][i % n] = num_list[i]);
        return answer;
    }
}
