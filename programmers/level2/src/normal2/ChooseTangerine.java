/*
https://school.programmers.co.kr/learn/courses/30/lessons/138476
        연습문제
        귤 고르기
*/

package normal2;

import java.util.*;
import java.util.stream.Collectors;

public class ChooseTangerine {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Long> tangerines = Arrays.stream(tangerine).boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        List<Long> list = tangerines.values().stream().collect(Collectors.toList());
        list.sort(Collections.reverseOrder());
        System.out.println("list = " + list);
        for (int i = 0; i < list.size(); i++) {
            k-= list.get(i);
            if(k<=0){
                return i+1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ChooseTangerine chooseTangerine = new ChooseTangerine();
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        int solution = chooseTangerine.solution(k, tangerine);
        System.out.println("solution = " + solution);
    }
}
