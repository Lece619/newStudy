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

        int answer = Integer.MAX_VALUE;



        int[][] fareArray = new int[n+1][n+1];
        for (int i = 0; i < fareArray.length; i++) {
            for (int j = 0; j < fareArray[0].length; j++) {
                if(i == j){
                    fareArray[i][j] = 0;
                }else{
                    fareArray[i][j] = 100000 * n ;
                }
            }
        }

        for (int[] fare : fares) {
            fareArray[fare[0]][fare[1]] = fare[2];
            fareArray[fare[1]][fare[0]] = fare[2];
        }

        for (int i = 0; i < fareArray.length; i++) {
            for (int j = 0; j < fareArray.length; j++) {
                System.out.print(fareArray[i][j] + " \t\t");
            }
            System.out.println();
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

        for (int i = 1; i < n+1; i++) {
            answer = Math.min(answer, fareArray[i][s] + fareArray[i][a] + fareArray[i][b]);
        }
        System.out.println("answer = " + answer);
        return answer;
    }

    public static void main(String[] args) {
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50},
                {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

        SharedTaxi sharedTaxi = new SharedTaxi();
        int answer = sharedTaxi.solution(6,4, 6, 2, fares);
    }
}
