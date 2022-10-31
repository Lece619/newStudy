/*
https://school.programmers.co.kr/learn/courses/30/lessons/131702
        연습문제
        고고학 최고의 발견
*/

package normal;

public class BestArchaeologyDiscovery {

    int answer = Integer.MAX_VALUE;
    int targetX = 0;
    int targetY = 0;
    int minSum;
    int[][] countHands;

    public int solution(int[][] clockHands) {
        minSum = checkZero2(clockHands);
        countHands = new int[clockHands.length][clockHands.length];
        dfs(0, clockHands, 0, 0);
        int step = 0;
//        while(!checkZero(clockHands)){
//            for (int i = 5; i >= 1; i--) {
//                if( findCoord(clockHands, i) ){
//                    break;
//                }
//            }
//            step++;
//            rotationHands(clockHands, 1, targetX, targetY);
//        }
        return answer;
    }

    private boolean findCoord(int[][] clockHands, int sum) {
        int len = clockHands.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if( i == targetX && j == targetY){
                    continue;
                }
                if( sum == sumHands(clockHands, i, j)){
                    targetX = i;
                    targetY = j;
                    return true;
                }
            }
        }

        return false;
    }

    private void dfs(int step, int[][] clockHands, int x, int y) {
        if(countHands[x][y] == 3){
            return;
        }
        if(checkZero(clockHands)){
            answer = Math.min(step, answer);
        }else{
            int len = clockHands.length;

            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if(clockHands[i][j] != 0){
                        countHands[i][j]++;
                        step++;
                        rotationHands(clockHands, 1, i, j);
                        dfs(step, clockHands, i, j);
                        rotationHands(clockHands, 3, i, j);
                        countHands[i][j]--;
                        step--;
                    }
                }
            }
        }
    }

    private void rotationHands(int[][] clockHands, int count, int xStep, int yStep) {
        int len = clockHands.length;
        int temp = clockHands[xStep][yStep];

        for (int i = Math.max(xStep-1, 0); i < Math.min(xStep+2,len); i++) {
            clockHands[i][yStep] = (clockHands[i][yStep] + count) % 4;
        }
        for (int i = Math.max(yStep-1, 0); i < Math.min(yStep+2,len); i++) {
            clockHands[xStep][i] = (clockHands[xStep][i] + count) % 4;
        }
        clockHands[xStep][yStep] = (temp + count) % 4;
    }

    private int sumHands(int[][] clockHands, int xStep, int yStep) {
        int len = clockHands.length;
        int result = 0;

        for (int i = Math.max(xStep-1, 0); i < Math.min(xStep+2,len); i++) {
            result += Math.min(1,clockHands[i][yStep]);
        }
        for (int i = Math.max(yStep-1, 0); i < Math.min(yStep+2,len); i++) {
            result += Math.min(1,clockHands[xStep][i]);
        }
        result -= Math.min(1,clockHands[xStep][yStep]);
        return result;
    }

    private boolean checkZero(int[][] clockHands) {
        for (int[] clockHand : clockHands) {
            for (int i : clockHand) {
                if(i != 0){
                    return false;
                }
            }
        }
        return true;
    }
    private int checkZero2(int[][] clockHands) {
        int sum = 0;
        for (int[] clockHand : clockHands) {
            for (int i : clockHand) {
                if(i != 0){
                    sum++;
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        BestArchaeologyDiscovery bestArchaeologyDiscovery = new BestArchaeologyDiscovery();
        int[][] clockHands = {{0,3,3,0}, {3,2,2,3}, {0,3,2,0}, {0,3,3,3}};

        // 0은 12시 방향, 1은 3시 방향, 2는 6시 방향, 3은 9시 방향
        int solution = bestArchaeologyDiscovery.solution(clockHands);
        System.out.println("solution = " + solution);
    }
}
