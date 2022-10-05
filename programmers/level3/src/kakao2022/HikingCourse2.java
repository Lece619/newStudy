/*
https://school.programmers.co.kr/learn/courses/30/lessons/118669
        2022 KAKAO TECH INTERNSHIP
        등산코스 정하기
*/

package kakao2022;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class HikingCourse2 {

    int[][] dp;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
        dp = new int[n+1][n+1];
        Arrays.sort(summits);
        int intensity = Integer.MAX_VALUE;
        int summitGate = 0;


        return answer;
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
