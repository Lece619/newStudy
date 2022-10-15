/*
https://school.programmers.co.kr/learn/courses/30/lessons/131702
        연습문제
        고고학 최고의 발견
*/

package normal;


public class BestArchaeologyDiscovery3 {


    public int solution(int[][] clockHands) {
        int answer = 0;
        boolean flag = true;
        while(flag) {
            flag = false;
            for (int i = 0; i < clockHands.length; i++) {
                for (int j = 0; j < clockHands.length; j++) {
                    int ro = canRotation(clockHands, i, j);
                    answer += ro;
                    if (ro == 1) {
                        flag = true;
                        rotationHands(clockHands, 1, i, j);
                    }
                }
            }
        }
        return answer;
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
    private int canRotation(int[][] clockHands, int x, int y) {
        for (int i = Math.max(x-1, 0); i < Math.min(x+2,clockHands.length); i++) {
            if(clockHands[i][y]==0){
                return 0;
            }
        }
        for (int i = Math.max(y-1, 0); i < Math.min(y+2,clockHands.length); i++) {
            if(clockHands[x][i]==0){
                return 0;
            }
        }
        return 1;
    }


    public static void main(String[] args) {
        BestArchaeologyDiscovery3 bestArchaeologyDiscovery = new BestArchaeologyDiscovery3();
        int[][] clockHands = {{0,3,3,0}, {3,2,2,3}, {0,3,2,0}, {0,3,3,3}};

        // 0은 12시 방향, 1은 3시 방향, 2는 6시 방향, 3은 9시 방향
        int solution = bestArchaeologyDiscovery.solution(clockHands);
        System.out.println("solution = " + solution);
    }
}
