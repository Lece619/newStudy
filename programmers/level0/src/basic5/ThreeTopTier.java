package basic5;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreeTopTier {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        Map<Integer, Integer> scores = IntStream.range(0, rank.length)
                .filter(i -> attendance[i])
                .boxed().collect(Collectors.toMap(i -> rank[i], i -> i));
        List<Integer> rankKey = scores.keySet().stream().sorted().collect(Collectors.toList());

        return scores.get(rankKey.get(0)) * 10000 + scores.get(rankKey.get(1)) * 100 + scores.get(rankKey.get(2));
    }

    public static void main(String[] args) {
        ThreeTopTier threeTopTier = new ThreeTopTier();
        System.out.println(threeTopTier.solution(new int[]{1, 2, 3, 4, 5}, new boolean[]{true, true, true, false, false}));
    }

}
