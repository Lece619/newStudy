/*
https://school.programmers.co.kr/learn/courses/30/lessons/118669
        2022 KAKAO TECH INTERNSHIP
        등산코스 정하기
*/

package kakao2022;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class HikingCourse2 {

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
        PriorityQueue<Area> queue = new PriorityQueue<>();
        queue.add(new Area(10, 4));
        queue.add(new Area(10, 3));

        Area peek = queue.peek();
        System.out.println("peek.getIntensity() = " + peek.getNodeNum());



        return answer;
    }

    public class Area implements Comparable<Area>{
        int intensity;
        int nodeNum;

        public Area(int intensity, int nodeNum) {
            this.intensity = intensity;
            this.nodeNum = nodeNum;
        }

        public int getIntensity() {
            return intensity;
        }

        public void setIntensity(int intensity) {
            this.intensity = intensity;
        }

        public int getNodeNum() {
            return nodeNum;
        }

        public void setNodeNum(int nodeNum) {
            this.nodeNum = nodeNum;
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

        for (int i : solution) {
            System.out.println(i);
        }
    }
}
