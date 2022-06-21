//https://www.acmicpc.net/problem/11049
//백준알고리즘 동적프로그래밍2 - 행렬 곱셈 순서

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Num11049 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][N];
        int[][] matrixArr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            matrixArr[i][0] = Integer.parseInt(st.nextToken());
            matrixArr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<N; i++) {
            for(int j=0; j<N-i; j++) {
                dp[j][j+i] = Integer.MAX_VALUE;
                for(int k=0; k<i; k++) {
                    int cost = dp[j][j+k] + dp[j+k+1][j+i] + matrixArr[j][0] * matrixArr[j+k][1] * matrixArr[j+i][1];
                    dp[j][j+i] = Math.min(dp[j][j+i], cost);
                }
            }
        }
        System.out.println(dp[0][N-1]);

    }
}
