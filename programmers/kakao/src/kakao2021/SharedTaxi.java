/*
https://school.programmers.co.kr/learn/courses/30/lessons/72413
        2021 KAKAO BLIND RECRUITMENT
        합승 택시 요금
*/

package kakao2021;

import java.util.HashMap;

public class SharedTaxi {

    HashMap<String, Integer> fareMap = new HashMap<>();

    public int solution(int n, int s, int a, int b, int[][] fares) {

        for (int[] fare : fares) {
            String key1 = fare[0] + "-" + fare[1];
            String key2 = fare[1] + "-" + fare[0];
            fareMap.put(key1, fare[2]);
            fareMap.put(key2, fare[2]);
        }

        int[][] fareArray = new int[n+1][n+1];
        for (int i = 0; i < fareArray.length; i++) {
            for (int j = 0; j < fareArray[0].length; j++) {
                if(i == j){
                    fareArray[i][j] = 0;
                }else{
                    fareArray[i][j] = 100000;
                }
            }
        }

        for (int[] fare : fares) {
            fareArray[fare[0]][fare[1]] = fare[2];
            fareArray[fare[1]][fare[0]] = fare[2];
        }

        for (int k = 1; k < n+1; k++) {
            for(int i = 1; i <= n; i++){
                for(int j = 1; j<=n; j++){
                    fareArray[i][j] = Math.min(fareArray[i][j], fareArray[i][k]+fareArray[k][j]);
                }
            }
        }

        for (int i = 0; i < fareArray.length; i++) {
            for (int j = 0; j < fareArray.length; j++) {
                System.out.print(fareArray[i][j] + " \t");
            }
            System.out.println();
        }

        System.out.println("fares = " + fareMap);
        int rootOne = fareArray[s][a] + fareArray[s][b];
        int rootTwo = fareArray[s][a] + fareArray[a][b];
        int rootThree = fareArray[s][b] + fareArray[b][a];
        int rootAnswer = fareArray[s][5] + fareArray[5][a] + fareArray[5][b];
        System.out.println("rootAnswer = " + rootAnswer);
        System.out.println("rootOne = " + rootOne);
        System.out.println("rootTwo = " + rootTwo);
        System.out.println("rootThree = " + rootThree);
        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50},
                {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

        SharedTaxi sharedTaxi = new SharedTaxi();
        int answer = sharedTaxi.solution(6,4, 6, 2, fares);
    }
}
