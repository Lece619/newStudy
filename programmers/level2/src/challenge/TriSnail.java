//https://school.programmers.co.kr/learn/courses/30/lessons/68645
//코딩테스트 연습
//        월간 코드 챌린지 시즌1
//        삼각 달팽이

package challenge;


public class TriSnail {
    int[][] move = {{1, 0}, {0, 1}, {-1, -1}};
    int moveIdx;
    int[][] tri;
    int x;
    int y;

    public int[] solution(int n) {
        int maxN = n * (n + 1) / 2;
        int[] answer = new int[maxN];
        tri = new int[n][];
        int limitX = n;
        int idx = 0;
        for (int i = 0; i < tri.length; i++) {
            tri[i] = new int[i + 1];

        }

        for (int i = 1; i < maxN + 1; i++) {
            tri[x][y] = i;
            int limitY = tri[x].length;
            if (i != maxN) {
                makeNext(x, y, limitX, limitY);
            }
        }

        for (int[] ints : tri) {
            for (int anInt : ints) {
                answer[idx++] = anInt;
            }
        }
        return answer;
    }

    private void makeNext(int x1, int y1, int limitX, int limitY) {
        int newX = x1 + move[moveIdx][0];
        int newY = y1 + move[moveIdx][1];
        if (newX >= 0 && newX < limitX && newY >= 0 && newY < limitY) {
            if (tri[newX][newY] == 0) {
                x = newX;
                y = newY;
                return;
            }
        }
        moveIdx = (moveIdx + 1) % 3;
        makeNext(x1, y1, limitX, limitY);
    }

    public static void main(String[] args) {
        int testN = 5;
        TriSnail triSnail = new TriSnail();
        int[] solution = triSnail.solution(testN);
        for (int i : solution) {
            System.out.print(i + ", ");
        }
    }
}
