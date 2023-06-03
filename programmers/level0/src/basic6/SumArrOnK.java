package basic6;

public class SumArrOnK {
    public int solution(int[][] board, int k) {
        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            int[] ints = board[i];
            for (int j = 0; j < ints.length - k; j++) {
                answer += ints[j];
            }
        }
        return answer;
    }
}
