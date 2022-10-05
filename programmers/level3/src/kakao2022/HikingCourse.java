/*
https://school.programmers.co.kr/learn/courses/30/lessons/118669
        2022 KAKAO TECH INTERNSHIP
        등산코스 정하기
*/

package kakao2022;

import java.util.*;
import java.util.stream.Collectors;

public class HikingCourse {

    int[][] routPath;
    Set<Integer> gateSet;
    Set<Integer> summitsSet;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
        routPath = new int[n+1][n+1];
        gateSet = Arrays.stream(gates).mapToObj(i -> (Integer) i).collect(Collectors.toSet());
        summitsSet = Arrays.stream(summits).mapToObj(i -> (Integer) i).collect(Collectors.toSet());

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                routPath[i][j] = 10_000_000;
            }
        }

        for (int[] path : paths) {
            routPath[path[0]][path[1]] = path[2];
            routPath[path[1]][path[0]] = path[2];
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n+1; k++) {
                    if(summitsSet.contains(i) && summitsSet.contains(j)){
                        continue;
                    }
                    routPath[i][j] = Math.min(routPath[i][j], Math.max(routPath[i][k], routPath[k][j]));
                }

            }
        }

        Arrays.sort(summits);
        int intensity = Integer.MAX_VALUE;
        int summitGate = 0;
        for (int summit : summits) {
            for (int i = 0; i < gates.length; i++) {
                    int inten = routPath[gates[i]][summit];
                    if(intensity > inten){
                        summitGate = summit;
                        intensity = inten;
                    }
            }

        }

        for (int[] ints : routPath) {
            for (int ints1 : ints) {
                System.out.print(ints1+"\t\t");
            }
            System.out.println();
        }

        return new int[]{summitGate,intensity};
    }


    public static void main(String[] args) {
        HikingCourse hikingCourse = new HikingCourse();

        int n = 7;
        int[][] paths = {{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}};
        int[] gates = {1};
        int[] summits = {2, 3, 4};

        int[] solution = hikingCourse.solution(n, paths, gates, summits);

        for (int i : solution) {
            System.out.println(i);
        }
    }
}
