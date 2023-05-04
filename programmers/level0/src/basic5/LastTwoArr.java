package basic5;

import java.util.Arrays;

public class LastTwoArr {
    public int[] solution(int[] num_list) {
        int len = num_list.length - 1;
        int newLast = num_list[len] > num_list[len - 1] ? num_list[len] - num_list[len - 1] : (num_list[len] * 2);
        int[] answer = Arrays.copyOf(num_list, num_list.length + 1);
        answer[len + 1] = newLast;
        return answer;
    }
}
