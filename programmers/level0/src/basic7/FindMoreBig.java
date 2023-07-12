package basic7;

import java.util.Arrays;

public class FindMoreBig {
    public int solution(int[] num_list) {
        int multiple = Arrays.stream(num_list).reduce((left, right) -> left * right).getAsInt();
        int sumPow = (int) Math.pow(Arrays.stream(num_list).sum(), 2);
        return multiple > sumPow ? 0 : 1;
    }
}
