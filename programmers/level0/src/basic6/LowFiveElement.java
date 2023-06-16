package basic6;

import java.util.Arrays;

public class LowFiveElement {
    public int[] solution(int[] num_list) {
        return Arrays.stream(num_list).sorted().limit(5).toArray();
    }
}
