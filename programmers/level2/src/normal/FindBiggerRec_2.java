// https://programmers.co.kr/learn/courses/30/lessons/12905
// 가장 큰 사각형 찾기
package normal;

//효율성 0;
public class FindBiggerRec_2 {
    public int solution(int [][]board) {
        int[][]dp = new int[board.length+1][board[0].length+1];
        int max=0;
        for (int i = 1; i <board.length+1; i++) {
            for (int j = 1; j < board[0].length+1; j++) {
                if(board[i-1][j-1]==1){
                    dp[i][j]=min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1])+1;
                    max=Math.max(dp[i][j],max);
                }
            }
        }
        return max*max;
    }
    public int min(int num1,int num2,int num3){
        return Math.min(Math.min(num1,num2),num3);
    }


    public static void main(String[] args) {

    }
}
