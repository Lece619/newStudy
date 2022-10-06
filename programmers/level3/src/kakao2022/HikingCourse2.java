/*
https://school.programmers.co.kr/learn/courses/30/lessons/118669
        2022 KAKAO TECH INTERNSHIP
        등산코스 정하기
*/

/*
다익스트라의 멀티포인트를 해결하는 알고리즘.

*/

package kakao2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HikingCourse2 {
    ArrayList<ArrayList<Area>> graph = new ArrayList<>();
    int[] intensities;
    Set<Integer> summitsSet;
    PriorityQueue<Area> queue;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        intensities = new int[n+1];
        queue = new PriorityQueue<>();
        IntStream.rangeClosed(0,n).forEach(i->graph.add(new ArrayList<>()));
        for (int[] path : paths) {
            graph.get(path[0]).add(new Area(path[1],path[2]));
            graph.get(path[1]).add(new Area(path[0],path[2]));
        }
        Arrays.fill(intensities,Integer.MAX_VALUE);
        summitsSet = Arrays.stream(summits).mapToObj(i -> (Integer) i).collect(Collectors.toSet());
        for (int gate : gates) {
            queue.offer(new Area(gate, 0));
            intensities[gate] = 0;
        }

        dijkstra();
        return findMin();
    }



    private void dijkstra() {

        while (!queue.isEmpty()){
            Area area = queue.poll();
            int nowIntens = area.getIntensity();
            int nowNum = area.nodeNum;
            if(intensities[nowNum] < nowIntens){
                continue;
            }
            if (summitsSet.contains(nowNum)) {
                continue;
            }
            for (Area area1 : graph.get(nowNum)) {
                int nextInten = Math.max(intensities[nowNum],area1.getIntensity());
                if(nextInten < intensities[area1.getNodeNum()]){
                    intensities[area1.getNodeNum()] = nextInten;
                    queue.offer(new Area(area1.nodeNum, nextInten));
                }
            }
        }


    }

    private int[] findMin() {
        PriorityQueue<Area> areaQ = new PriorityQueue<>();
        for (Integer summit : summitsSet) {
            areaQ.offer(new Area(summit, intensities[summit]));
        }
        Area peek = areaQ.peek();
        return new int[]{peek.getNodeNum(), peek.getIntensity()};
    }

    public class Area implements Comparable<Area>{
        int nodeNum;
        int intensity;

        public Area( int nodeNum, int intensity) {
            this.nodeNum = nodeNum;
            this.intensity = intensity;
        }

        public int getIntensity() {
            return intensity;
        }

        public int getNodeNum() {
            return nodeNum;
        }

        @Override
        public int compareTo(Area o) {
            if(this.getIntensity() == o.getIntensity()){
                return this.getNodeNum() - o.getNodeNum();
            }
            return this.getIntensity() - o.getIntensity();
        }
    }

    public static void main(String[] args) {
        HikingCourse2 hikingCourse = new HikingCourse2();

        int n = 7;
        int[][] paths = {{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}};
        int[] gates = {3, 7};
        int[] summits = {1, 5};

        int[] solution = hikingCourse.solution(n, paths, gates, summits);
        System.out.println("solution = " + solution);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
