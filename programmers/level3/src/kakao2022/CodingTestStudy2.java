/*
https://school.programmers.co.kr/learn/courses/30/lessons/118668
        2022 KAKAO TECH INTERNSHIP
        코딩 테스트 공부
*/

package kakao2022;

public class CodingTestStudy2 {

    int[][] dp;
    public int solution(int alp, int cop, int[][] problems) {
        int targetAlp = alp;
        int targetCop = cop;

        for (int[] problem : problems) {
            targetAlp = Math.max(problem[0],targetAlp);
            targetCop = Math.max(problem[1],targetCop);
        }

        dp = new int[targetAlp+2][targetCop+2];
        for (int i = alp; i < dp.length; i++) {
            for (int j = cop; j < dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[alp][cop] = 0;

        for (int i = alp; i <= targetAlp; i++) {
            for (int j = cop; j <= targetCop; j++) {
                dp[i+1][j] = Math.min(dp[i+1][j],dp[i][j]+1);
                dp[i][j+1] = Math.min(dp[i][j+1],dp[i][j]+1);

                for (int[] problem : problems) {
                    if(i >= problem[0] && j >= problem[1]){
                        dp[Math.min(i+problem[2],targetAlp)][Math.min(j+problem[3],targetCop)]
                                = Math.min(dp[Math.min(i+problem[2],targetAlp)][Math.min(j+problem[3],targetCop)],dp[i][j]+problem[4]);
                    }
                }
            }
        }
        return dp[targetAlp][targetCop];
    }


    public static void main(String[] args) {
        int alp = 10;
        int cop = 10;
        int[][] problems = {{10,15,2,1,2},{20,20,3,3,4}};

        CodingTestStudy2 codingTestStudy = new CodingTestStudy2();
        System.out.println("codingTestStudy.solution(alp, cop, problems) = " + codingTestStudy.solution(alp, cop, problems));
    }
}
