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

                if(i == j){
                    routPath[i][j] = 0;
                }else{
                    if(gateSet.contains(i) && gateSet.contains(j)){
                        routPath[i][j] = 0;
                    }
                    if(summitsSet.contains(i) && summitsSet.contains(j)){
                        routPath[i][j] = 1000000;
                    }
                }
            }
        }

        for (int[] path : paths) {
            routPath[path[0]][path[1]] = path[2];
            routPath[path[1]][path[0]] = path[2];
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n+1; k++) {
                    if(routPath[i][j] == 0 || routPath[i][k] == 0 || routPath[k][j] == 0){
                        continue;
                    }
                    routPath[i][j] = Math.min(routPath[i][j], Math.max(routPath[i][k], routPath[k][j]));
                    routPath[j][i] = routPath[i][j];
                }

                if(summitsSet.contains(i) && summitsSet.contains(j)){
                    routPath[i][j] = 100;
                    routPath[j][i] = 100;
                }
            }
        }

        Arrays.sort(summits);
        int intensity = Integer.MAX_VALUE;
        int summitGate = 0;
        for (int summit : summits) {
            for (int i = 0; i < gates.length; i++) {
                for (int j = 0; j < gates.length; j++) {
                    int inten = Math.max(routPath[gates[i]][summit], routPath[summit][gates[j]]);
                    if(intensity > inten){
                        summitGate = summit;
                        intensity = inten;
                    }
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
        int[][] paths = {{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}};
        int[] gates = {3, 7};
        int[] summits = {1, 5};

        int[] solution = hikingCourse.solution(n, paths, gates, summits);

        for (int i : solution) {
            System.out.println(i);
        }
    }
}
