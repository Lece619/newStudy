/*
https://school.programmers.co.kr/learn/courses/30/lessons/160585
        연습문제
        혼자서 하는 틱택토
*/

package notSolved;

public class TicTacTokAlone {
    public int solution(String[] board) {
        int answer = -1;
        return answer;
    }

    public static void main(String[] args) {
        String[] board = {"O.X", ".O.", "..X"};
        TicTacTokAlone ticTacTokAlone = new TicTacTokAlone();
        int solution = ticTacTokAlone.solution(board);
        System.out.println("solution = " + solution);
    }
}
