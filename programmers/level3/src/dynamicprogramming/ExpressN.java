/*
https://school.programmers.co.kr/learn/courses/30/lessons/42895
        동적계획법(Dynamic Programming)
        N으로 표현
*/

package dynamicprogramming;

import java.util.Arrays;

public class ExpressN {

    public int solution(int N, int number) {

        int[] dp = new int[number + 1 + 11 + N * N];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[1] = 2;
        makeDp(N, dp);


        for (int i = 1; i < number; i++) {
            findNext(dp, i, N);
        }

        for (int i : dp) {
            System.out.print(i + "  ");
        }

        return dp[number] > 8 ? -1 : dp[number];
    }

    private void makeDp(int n, int[] dp) {
        int idx = 1;
        while( n < dp.length){
            dp[n] = idx++;
            n = n * 10 + n;
        }
    }

    private void findNext(int[] dp, int i, int N) {
        dp[i + N] = Math.min(dp[i + N], dp[i] + 1);
        dp[i + 1] = Math.min(dp[i + 1], dp[i] + 2);
        dp[i + 11] = Math.min(dp[i + 11], dp[i] + 3);
        dp[i - 1] = Math.min(dp[i - 1], dp[i] + 2);
        int mod = i % 11;
        if(mod != 0) {
            dp[i + 11] = Math.min(dp[i + 11], (i + 11) / 11 * 3 + mod);
        }

    }

    public static void main(String[] args) {
        int N = 4;
        int number = 31;
        ExpressN expressN = new ExpressN();
        int solution = expressN.solution(N, number);
        System.out.println();
        System.out.println("solution = " + solution);
    }
}
