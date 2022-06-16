package maester;

public class GameMap {

    static int min = -1;
    static boolean[][] check;
    static int n, m;
    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, -1, 0, 1};

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i][j] == 1) {
                    check[i][j] = true;
                }
            }
        }

        int answer = 0;
        return answer;
    }

    public void move(int x, int y, int len) {
        len++;
        for (int i = 0; i < moveX.length; i++) {
            int newX = x + moveX[i];
            int newY = y + moveY[i];

        }
    }

    //이동이 가능한지 판단
    public boolean isMoveOk(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        return check[x][y];
    }

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        new GameMap().solution(maps);
    }
}
