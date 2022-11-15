/*
https://school.programmers.co.kr/learn/courses/30/lessons/42861
        탐욕법(Greedy)
        섬 연결하기
*/
package normal;

import java.util.*;
import java.util.stream.IntStream;

public class IslandLinks {

    public int solution(int n, int[][] costs) {

        int answer = 0;

        ArrayList<Island> islands = new ArrayList<>();
        ArrayList<Set<Integer>> findCycleAll = new ArrayList<>();

        IntStream.range(0,n).forEach(i->{
            findCycleAll.add(new HashSet<>(){});
            findCycleAll.get(i).add(i);
        });

        for (int[] cost : costs) {
            islands.add(new Island(cost[0],cost[1],cost[2]));
        }
        Collections.sort(islands);

        System.out.println("islands = " + islands);

        for (Island island : islands) {
            int start = island.getStart();
            int end = island.getEnd();
            int len = island.getLen();

            Set<Integer> startCycle = findCycleAll.get(start);
            Set<Integer> endCycle = findCycleAll.get(end);

            if(startCycle.contains(end) || endCycle.contains(start)){
                continue;
            }

            for (Integer integer : startCycle) {
                if(integer != start)
                    findCycleAll.get(integer).addAll(endCycle);
            }

            for (Integer integer : endCycle) {
                if(integer != end)
                    findCycleAll.get(integer).addAll(startCycle);
            }

            startCycle.addAll(endCycle);
            endCycle.addAll(startCycle);

            answer += len;

        }

        return answer;
    }


    static class Island implements Comparable<Island>{

        int start;
        int end;
        int len;

        public Island(int start, int end, int len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getLen() {
            return len;
        }

        @Override
        public int compareTo(Island o) {
            return this.len - o.len;
        }

        @Override
        public String toString() {
            return this.start + " " + this.end + " " + this.len;
        }
    }

    public static void main(String[] args) {
        IslandLinks islandLink = new IslandLinks();

        int n = 5;
        int[][] costs = {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}};
        int solution = islandLink.solution(n, costs);

        System.out.println("solution = " + solution);
    }
}