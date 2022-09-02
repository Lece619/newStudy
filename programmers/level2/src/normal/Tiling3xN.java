/*
https://school.programmers.co.kr/learn/courses/30/lessons/12902
        코딩테스트 연습
        연습문제
        3 x n 타일링
*/
package normal;

public class Tiling3xN {
    public int solution(int n) {

        int mod  = 1_000_000_007;
        long[] dp = new long[2501];

        if( n%2 != 0 ){
            return 0;
        }
        n /= 2;
        //점화식이 가능한가
        //2 => 3 4 ==> 11
        dp[0] = 1;
        dp[1] = 3;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] * 3;
            for (int j = 0; j < i-1; j++) {
                dp[i] += 2 * dp[j];
            }
            dp[i] = dp[i] % mod;
        }
        int answer = (int) (dp[n] % mod);
        return answer;
    }

    public static void main(String[] args) {
        Tiling3xN test = new Tiling3xN();
        System.out.println("test.solution(11) = " + test.solution(8));
    }
}
