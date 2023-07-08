package basic7;

import java.util.Arrays;

public class FindInt {
    public int solution(int[] num_list, int n) {
        //return IntStream.of(numList).anyMatch(num -> num == n) ? 1 : 0;
        return Arrays.stream(num_list).filter(num -> num == n).findAny().isEmpty() ? 0 : 1;
    }
}
