package basic5;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MakeArr1 {

    public int[] solution(int n, int k) {
        return IntStream.rangeClosed(1, n / k).map(i -> i * k).toArray();
    }

    public int[] solution(int[] arr) {

        return Arrays.stream(arr).map(i -> {
                    if (i >= 50 && i % 2 == 0)
                        return i / 2;
                    if (i < 50 && i % 2 == 1)
                        return i * 2;
                    else
                        return i;
                }).toArray();
    }
    public int solution(int[] arr, int idx) {
        return IntStream.range(idx,arr.length).filter(i -> arr[i] == 1).findFirst().orElse(-1);
    }
}
