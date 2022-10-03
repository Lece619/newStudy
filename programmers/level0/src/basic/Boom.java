package basic;

public class Boom {
    public int solution(int[][] board) {
        int answer = 0;
        int[][] boardCopy = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boardCopy[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 1){
                    for (int k = Math.max(i-1,0); k < Math.min(i+2,board.length); k++) {
                        for (int l = Math.max(j-1,0); l < Math.min(j+2, board[0].length); l++) {
                            boardCopy[k][l] = 1;
                        }
                    }
                }
            }
        }

        for (int[] ints : boardCopy) {
            for (int anInt : ints) {
                if(anInt == 0){
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}};
        Boom boom = new Boom();
        System.out.println("boom.solution(board) = " + boom.solution(board));
    }
}
