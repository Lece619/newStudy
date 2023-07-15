package basic7;

import java.util.stream.IntStream;

public class SplitArr {
    public int[] solution(int[] num_list, int n) {
        int length = num_list.length;
        int[] answer = new int[length];
        IntStream.range(0, length).forEach(i -> answer[i] = num_list[(i + n) % length]);
        return answer;
    }
}
