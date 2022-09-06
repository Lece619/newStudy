/*
https://school.programmers.co.kr/learn/courses/30/lessons/12913
        연습문제
        땅따먹기
*/

package normal;

public class EatTheGround {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length + 1][4];

        //다음 패널을 가정하고 이번 숫자 결정
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if(k != j){
                        max = Math.max(max, dp[i-1][k]);
                    }
                }
                dp[i][j] = land[i-1][j] + max;
            }
        }

        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer,dp[land.length][i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        EatTheGround eatTheGround = new EatTheGround();
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        System.out.println("eatTheGround = " + eatTheGround.solution(land));
    }
}
