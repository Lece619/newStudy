package basic6;

import java.util.Arrays;

public class CopyArrN {
    public int[] solution(int[] num_list, int n) {
        //COPY ARR UNTIL N
        return Arrays.stream(num_list).limit(n).toArray();
    }
}
