/*
https://school.programmers.co.kr/learn/courses/30/lessons/133501
        연습문제
        야간 전술보행
*/

package normal;

public class NightWalking {
    public int solution(int distance, int[][] scope, int[][] times) {
        int answer = 0;

        boolean[] walking = new boolean[distance + 1];

        for (int i = 0; i < scope.length; i++) {
            int[] scopes = scope[i];
            int[] time = times[i];
            int start = Math.min(scopes[0], scopes[1]);
            int end = Math.max(scopes[0], scopes[1]);
            int allTime = time[0] + time[1];
            for (int j = start; j <= end; j++) {
                walking[j] = (j-1) % allTime < time[0];
            }
        }

        for (int i = 0; i < walking.length; i++) {
            if(walking[i]){
                return i;
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        NightWalking nightWalking = new NightWalking();

        int distance = 10;

        int[][] scope = {{3, 4}, {5, 8}};
        int[][] times = {{2, 5}, {4, 3}};

        int solution = nightWalking.solution(distance, scope, times);
        System.out.println("solution = " + solution);
    }

}
