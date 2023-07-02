package basic7;

public class MakeSquare {
    
    int[] row = {0 , 1, 0, -1};
    int[] col = {1, 0, -1, 0};
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];

        int dir = 0;
        int nowRow = 0;
        int nowCol = 0;

        for (int i = 1; i <= n * n; i++) {
            answer[nowRow][nowCol] = i;

            int nextRow = nowRow + row[dir];
            int nextCol = nowCol + col[dir];

            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || answer[nextRow][nextCol] != 0) {
                dir = (dir + 1) % 4;
                nextRow = nowRow + row[dir];
                nextCol = nowCol + col[dir];
            }

            nowRow = nextRow;
            nowCol = nextCol;
        }
        
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("new  = " + new MakeSquare().solution(4));

    }
}
