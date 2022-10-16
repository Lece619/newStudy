/*
https://school.programmers.co.kr/learn/courses/30/lessons/131702
        연습문제
        고고학 최고의 발견
*/

package normal;


import java.util.ArrayList;

public class BestArchaeologyDiscovery4 {


    public int solution(int[][] clockHands) {

        int answer = 0;

        while (checkZero(clockHands)) {

            ArrayList<int[]> dots = new ArrayList<>();

            for (int i = 0; i < clockHands.length; i++) {
                for (int j = 0; j < clockHands.length; j++) {
                    if (CanRocation(i, j, clockHands)) {
                        dots.add(new int[]{i, j});
                    }
                }
            }

            makeRotaion(clockHands, dots);
            answer += dots.size();
        }

        return answer;
    }

    private void makeRotaion(int[][] clockHands, ArrayList<int[]> dots) {
        for (int[] dot : dots) {
            int xStep = dot[0];
            int yStep = dot[1];
            for (int i = Math.max(xStep - 1, 0); i < Math.min(xStep + 2, clockHands.length); i++) {
                clockHands[i][yStep] = ( clockHands[i][yStep] + 1) % 4;
            }
            for (int i = Math.max(yStep - 1, 0); i < Math.min(yStep + 2, clockHands.length); i++) {
                clockHands[xStep][i] = ( clockHands[xStep][i] + 1) % 4;
            }
            clockHands[xStep][yStep] = ( clockHands[xStep][yStep] + 3) % 4;
        }
    }

    private boolean checkZero(int[][] clockHands) {
        for (int[] clockHand : clockHands) {
            for (int i : clockHand) {
                if (i != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean CanRocation(int xStep, int yStep, int[][] clockHands) {

        for (int i = Math.max(xStep - 1, 0); i < Math.min(xStep + 2, clockHands.length); i++) {
            if (clockHands[i][yStep] == 0) {
                return false;
            }
        }
        for (int i = Math.max(yStep - 1, 0); i < Math.min(yStep + 2, clockHands.length); i++) {
            if (clockHands[xStep][i] == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        BestArchaeologyDiscovery4 bestArchaeologyDiscovery = new BestArchaeologyDiscovery4();
        int[][] clockHands = {{0, 3, 3, 0}, {3, 2, 2, 3}, {0, 3, 2, 0}, {0, 3, 3, 3}};

        // 0은 12시 방향, 1은 3시 방향, 2는 6시 방향, 3은 9시 방향
        int solution = bestArchaeologyDiscovery.solution(clockHands);
        System.out.println("solution = " + solution);
    }
}
