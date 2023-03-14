/*
https://school.programmers.co.kr/learn/courses/30/lessons/160585
        연습문제
        혼자서 하는 틱택토
*/

package notSolved;

public class TicTacTokAlone {

    static final int SUCCESS = 1;
    static final int FAIL = 0;
    static final String MatchO = "OOO";
    static final String MatchX = "XXX";
    int numO = 0;
    int numX = 0;
    int countO = 0;
    int countX = 0;

    public int solution(String[] board) {

        if (unmatchedNumber(board)) {
            return FAIL;
        }

        if (moreGameOver(board)) {
            return FAIL;
        }

        if(WinCheck(board)){
            return FAIL;
        }
        return SUCCESS;
    }

    private boolean WinCheck(String[] board) {
        if(countO == 1){
            return numO == numX;
        }
        if(countX == 1){
            return numO > numX;
        }
        return false;
    }

    private boolean unmatchedNumber(String[] board) {
        numO = findCharNum('O', board);
        numX = findCharNum('X', board);

        if (numX > numO) {
            return true;
        }
        if (numO - numX > 1) {
            return true;
        }

        return false;
    }

    private int findCharNum(char target, String[] board) {
        int num = 0;
        for (String s : board) {
            for (char c : s.toCharArray()) {
                if (c == target) {
                    num++;
                }
            }
        }
        return num;
    }

    private boolean moreGameOver(String[] board) {
        checkRowMatch(board);
        checkColMatch(board);
        checkCrossMatch(board);
        if(countO + countX <= 1){
            return false;
        }
        if(countO == 2 && countX == 0){
            return false;
        }
        return true;
    }

    private void checkRowMatch(String[] board) {

        for (String s : board) {
            countOX(s);
        }
    }

    private void checkColMatch(String[] board) {

        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                sb.append(board[j].charAt(i));
            }

            countOX(sb.toString());
        }
    }

    private void checkCrossMatch(String[] board) {

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            sb1.append(board[i].charAt(i));
            sb2.append(board[board.length - i - 1].charAt(i));
        }
        countOX(sb1.toString());
        countOX(sb2.toString());
    }

    private void countOX(String s) {
        if (s.equals(MatchO)) {
            countO++;
        }
        if (s.equals(MatchX)) {
            countX++;
        }
    }

    public static void main(String[] args) {
        String[] board = {"OOO", "...", "XXX"};
        TicTacTokAlone ticTacTokAlone = new TicTacTokAlone();
        int solution = ticTacTokAlone.solution(board);
        System.out.println("solution = " + solution);
    }
}
