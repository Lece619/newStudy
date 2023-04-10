/*
https://school.programmers.co.kr/learn/courses/30/lessons/178871
        연습문제
        달리기 경주
*/

package normal2;

import java.util.Arrays;

public class RunningRace {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        return answer;
    }

    public static void main(String[] args) {
        RunningRace runningRace = new RunningRace();
        String[] solution = runningRace.solution(
                new String[]{"mumu", "soe", "poe", "kai"},
                new String[]{"kai", "kai", "mine", "mine"}
        );
        Arrays.stream(solution).forEach(System.out::println);
    }
}
