/*
https://school.programmers.co.kr/learn/courses/30/lessons/132266
        연습문제
        부대복귀
*/

package normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class ReturnToTheUnit {

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        IntStream.rangeClosed(0,n).forEach(i-> graph.add(new ArrayList<>()));
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        int[] findRoads = new int[n+1];
        Arrays.fill(findRoads, Integer.MAX_VALUE);

        queue.add(new int[]{0, destination});
        findRoads[destination] = 0;

        dijkstra(graph, queue, findRoads);

        return Arrays.stream(sources).map(i -> findRoads[i] == Integer.MAX_VALUE ? -1 : findRoads[i]).toArray();
    }

    private void dijkstra(ArrayList<ArrayList<Integer>> graph, PriorityQueue<int[]> queue, int[] findRoads) {
        while(!queue.isEmpty()){
            int[] nowQueue = queue.poll();
            int nowDist = nowQueue[0];
            int nowNode = nowQueue[1];
            ArrayList<Integer> nextNodes = graph.get(nowNode);
            if(nowDist > findRoads[nowNode]){
                continue;
            }
            nowDist++;
            for (Integer nextNode : nextNodes) {
                if(findRoads[nextNode] > nowDist){
                    findRoads[nextNode] = nowDist;
                    queue.add(new int[]{nowDist, nextNode});
                }
            }
        }
    }


    public static void main(String[] args) {
        ReturnToTheUnit returnToTheUnit = new ReturnToTheUnit();
        int n = 5;
        int[][] roads ={{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}};
        int[] sources = {1, 3, 5};
        int destination = 5;

        int[] solution = returnToTheUnit.solution(n, roads, sources, destination);
        for (int i : solution) {
            System.out.print(i + "  ");
        }
    }
}
