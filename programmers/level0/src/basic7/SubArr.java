package basic7;

import java.util.Arrays;

public class SubArr {
    public int[] solution(int[] num_list, int n) {
        return Arrays.copyOfRange(num_list, n - 1, num_list.length);
    }
}
