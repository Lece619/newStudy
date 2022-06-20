import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/11066
//백준 알고리즘 - 파일 합치기
public class Num11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int Test = 0; Test < T; Test++) {
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            long[] file = new long[K+1];
            long[] sum = new long[K+1];
            long[][] dp = new long[K+2][K+2];
            long sumTotal = 0;

            for (int i = 1; i <= K; i++) {
                file[i] = Long.parseLong(st.nextToken());
                sum[i] = sum[i-1] + file[i];
            }
            //뒤에 범위 = i
            for (int i = 2; i <= K; i++) {
                //처음수 = j
                for (int j = i-1; j > 0; j--) {
                    dp[j][i] = Integer.MAX_VALUE;
                    //분할 범위 k
                    for (int k = j; k <= i; k++) {
                        dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k+1][i]);
                    }
                    //sum[i] - sum[j-1] 를 해줘야 최소에 전체값더한것이 최소값이된다.
                    dp[j][i] += sum[i] - sum[j-1];
                }
            }
            System.out.println(dp[1][K]);
        }
    }
}
