/*
https://school.programmers.co.kr/learn/courses/30/lessons/49189
        그래프
        가장 먼 노드
*/
package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class FurthermostNode {

    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    int[] dict;
    PriorityQueue<int[]> queue;
    int max = 0;

    public int solution(int n, int[][] edge) {
        int answer = 0;
        dict = new int[n+1];
        Arrays.fill(dict, Integer.MAX_VALUE);
        dict[0] = 0;
        dict[1] = 0;
        IntStream.rangeClosed(0,n).forEach(i->graph.add(new ArrayList<>()));
        for (int[] path : edge) {
            graph.get(path[0]).add(path[1]);
            graph.get(path[1]).add(path[0]);
        }
        queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        queue.offer(new int[]{0,1});

        dijkstra();

        return (int) Arrays.stream(dict).filter(i->i==max).count();
    }

    private void dijkstra() {
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            int nowDist = now[0];
            int nowNode = now[1];
            if(nowDist > dict[nowNode]){
                continue;
            }
            for (Integer next : graph.get(nowNode)) {
                if(dict[next] > nowDist + 1 ){
                    dict[next] = nowDist + 1;
                    max = Math.max(nowDist + 1, max);
                    queue.offer(new int[]{dict[next], next});
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        FurthermostNode furthermostNode = new FurthermostNode();
        System.out.println("furthermostNode.solution(n, edge) = " + furthermostNode.solution(n, edge));
    }
}
