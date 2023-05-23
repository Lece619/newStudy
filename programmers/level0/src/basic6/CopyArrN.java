package basic6;

import java.util.Arrays;

public class CopyArrN {
    public int[] solution(int[] num_list, int n) {
        //COPY ARR UNTIL N
        return Arrays.stream(num_list).limit(n).toArray();
    }

    public int[] solution(int[] arr, int[] query) {

        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                arr = Arrays.stream(arr).limit(query[i] + 1).toArray();
            } else {
                arr = Arrays.stream(arr).skip(query[i]).toArray();
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        new CopyArrN().solution(new int[]{0, 1, 2, 3, 4, 5}, new int[]{4, 1, 2});
    }
}
