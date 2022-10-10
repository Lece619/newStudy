package basic2;

import java.util.Arrays;
import java.util.Comparator;

public class StrangeSort {
    public int[] solution(int[] numlist, int n) {

        return Arrays.stream(numlist).mapToObj(i -> (Integer) i).sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int o1Int = Math.abs(o1 - n);
                int o2Int = Math.abs(o2 - n);
                if (o2Int == o1Int) {
                    return o2 - o1;
                }
                return o1Int - o2Int;
            }
        }).mapToInt(i -> (int) i).toArray();
    }

    public static void main(String[] args) {
        StrangeSort strangeSort = new StrangeSort();
        int[] numlist = {10000,20,36,47,40,6,10,7000};
        int n = 30;
        int[] solution = strangeSort.solution(numlist, n);

    }
}
