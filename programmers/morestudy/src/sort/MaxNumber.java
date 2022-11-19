/*
https://school.programmers.co.kr/learn/courses/30/lessons/42746
        정렬
        가장 큰 수
*/

package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MaxNumber {
    public String solution(int[] numbers) {
//        6, 10 --> 610 , 106
        // 610 - 106
        List<String> number = Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.toList());

        number.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -(o1+o2).compareTo(o2+o1);
            }
        });
        String answer = number.stream().collect(Collectors.joining());

        return answer.charAt(0) == '0' ? "0" : answer;
    }

    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        new MaxNumber().solution(numbers);
    }
}
