/*
https://school.programmers.co.kr/learn/courses/30/lessons/152996
        연습문제
        시소 짝꿍
*/


package normal2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SeesawPartner {
    public long solution(int[] weights) {
        long answer = 0;
        /* 틀린로직 다시생각
        Set<Integer> weightAll = new HashSet<>();

        Arrays.stream(weights).forEach(weightAll::add);
        answer = weights.length - weightAll.size();

        weightAll.clear();
        Arrays.stream(weights).forEach(i->{
            weightAll.add(i * 2);
            weightAll.add(i * 3);
            weightAll.add(i * 4);
        });
        answer = weights.length * 3 - (answer * 2 + weightAll.size());
        */
        return answer;
    }

    public static void main(String[] args) {
        SeesawPartner seesawPartner = new SeesawPartner();
        int[] weights = {100,180,360,100,270};
        long solution = seesawPartner.solution(weights);
        System.out.println("solution = " + solution);
    }
}
