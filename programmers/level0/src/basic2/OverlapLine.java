package basic2;

import java.util.HashMap;
import java.util.stream.IntStream;

public class OverlapLine {
    public int solution(int[][] lines) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int line[]: lines) {
            IntStream.range(Math.min(line[0],line[1]),Math.max(line[0],line[1])).forEach(i->count.put(i, count.getOrDefault(i, 0)+1));
        }

        return (int) count.values().stream().filter(i -> i > 1).count();
    }

    public static void main(String[] args) {
        int solution = new OverlapLine().solution(new int[][]{{1, 2}, {2, 3}, {0, 2}});
        System.out.println("solution = " + solution);
    }
}
