/*
https://school.programmers.co.kr/learn/courses/30/lessons/42861
        탐욕법(Greedy)
        섬 연결하기
*/
package normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class IslandLink {

    public int solution(int n, int[][] costs) {

        ArrayList<ArrayList<Island>> graph = new ArrayList<>();
        PriorityQueue<Island> nextCheck = new PriorityQueue<>();
        int[] bridge = new int[n];

        makeGraph(n, costs, graph);
        settingStart(graph, nextCheck, bridge);
        dijkstra(graph, nextCheck, bridge);

        int idx = 0;
        for (int i : bridge) {
            System.out.println((idx++) + " " + i);
        }
        return Arrays.stream(bridge).sum();
    }

    private void makeGraph(int n, int[][] costs, ArrayList<ArrayList<Island>> graph) {
        IntStream.range(0, n).forEach(i->graph.add(new ArrayList<>()));
        for (int[] cost : costs) {
            graph.get(cost[0]).add(new Island(cost[1], cost[2]));
            graph.get(cost[1]).add(new Island(cost[0], cost[2]));
        }
    }

    private void settingStart(ArrayList<ArrayList<Island>> graph, PriorityQueue<Island> nextCheck, int[] bridge) {
        Arrays.fill(bridge, Integer.MAX_VALUE);
        bridge[0] = 0;
        nextCheck.addAll(graph.get(0));
    }

    private void dijkstra(ArrayList<ArrayList<Island>> graph, PriorityQueue<Island> nextCheck, int[] bridge){

        while (!nextCheck.isEmpty()){

            Island poll = nextCheck.poll();
            int nowStart = poll.getStart();
            int nowLen = poll.getLen();

            if(bridge[nowStart] <= nowLen){
                continue;
            }
            bridge[nowStart] = nowLen;

            addNextCheck(graph, nextCheck, bridge, nowStart);
        }

    }

    private void addNextCheck(ArrayList<ArrayList<Island>> graph, PriorityQueue<Island> nextCheck, int[] bridge, int nowStart) {
        ArrayList<Island> nextIsland = graph.get(nowStart);
        for (Island island : nextIsland) {
            if(bridge[island.getStart()] >= island.getLen()){
                nextCheck.add(island);
            }
        }
    }

    static class Island implements Comparable<Island>{

        int start;
        int len;

        public Island(int start, int len) {
            this.start = start;
            this.len = len;
        }

        public int getStart() {
            return start;
        }

        public int getLen() {
            return len;
        }

        @Override
        public int compareTo(Island o) {
            return this.len - o.len;
        }
    }

    public static void main(String[] args) {
        IslandLink islandLink = new IslandLink();

        int n = 5;
        int[][] costs = {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}};
        int solution = islandLink.solution(n, costs);

        System.out.println("solution = " + solution);
    }
}
