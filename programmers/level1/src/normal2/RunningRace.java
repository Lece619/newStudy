/*
https://school.programmers.co.kr/learn/courses/30/lessons/178871
        연습문제
        달리기 경주
*/

package normal2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RunningRace {
    public String[] solution2(String[] players, String[] callings) {
        List<String> playerRank = Arrays.stream(players).collect(Collectors.toList());
        for (String calling : callings) {
            int index = playerRank.indexOf(calling);
            playerRank.remove(index--);
            playerRank.add(index, calling);
        }
        return playerRank.toArray(new String[0]);
    }
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = IntStream.range(0, players.length)
                .boxed()
                .collect(Collectors.toMap(i -> players[i], i -> i));

        for (String calling : callings) {
            Integer calledPersonNum = rank.get(calling);
            int downPersonNum = calledPersonNum - 1;
            String downPerson = players[downPersonNum];
            players[downPersonNum] = calling;
            players[calledPersonNum] = downPerson;
            rank.put(calling, downPersonNum);
            rank.put(downPerson, calledPersonNum);
        }

        return players;
    }
    public static void main(String[] args) {
        RunningRace runningRace = new RunningRace();
        String[] solution = runningRace.solution(
                new String[]{"mumu", "soe", "poe", "kai", "mine"},
                new String[]{"kai", "kai", "mine", "mine"}
        );
        Arrays.stream(solution).forEach(System.out::println);
    }
}
