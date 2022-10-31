/*
https://school.programmers.co.kr/learn/courses/30/lessons/131702
        연습문제
        고고학 최고의 발견
*/

package normal;

public class BestArchaeologyDiscovery5 {


    public int solution(int[][] clockHands) {

        int answer = 0;
        int[][] checkRotation = new int[clockHands.length][clockHands.length];



        for (int[] ints : clockHands) {
            for (int anInt : ints) {
                System.out.print("\t" + anInt);
            }
            System.out.println();
        }
        System.out.println();
        return answer;
    }

    private void rotationInPoint(int[][] clockHands, int row, int col, int step) {
        int startRow = Math.max(row - 1, 0);
        int endRow = Math.min(row + 1, clockHands.length - 1);
        int startCol = Math.max(col - 1, 0);
        int endCol = Math.min(col + 1, clockHands.length - 1);
        for (int i = startRow; i <= endRow; i++) {
            clockHands[i][col] = (clockHands[i][col] + step) % 4;
        }
        for (int i = startCol; i <= endCol; i++) {
            clockHands[row][i] = (clockHands[row][i] + step) % 4;
        }
        clockHands[row][col] = (clockHands[row][col] + 3) % 4;
    }


    public static void main(String[] args) {
        BestArchaeologyDiscovery5 bestArchaeologyDiscovery = new BestArchaeologyDiscovery5();
        int[][] clockHands = {{0, 3, 3, 0},
                              {3, 2, 2, 3},
                              {0, 3, 2, 0},
                              {0, 3, 3, 3}};
        /*
        3 4 4 3
        7 2 3 7
        6 5 5 4
        6 3 2 3

        3 0 0 3
        3 2 3 3
        2 1 1 0
        2 3 2 3

        */

        // 0은 12시 방향, 1은 3시 방향, 2는 6시 방향, 3은 9시 방향
        int solution = bestArchaeologyDiscovery.solution(clockHands);
        System.out.println("solution = " + solution);
    }
}
