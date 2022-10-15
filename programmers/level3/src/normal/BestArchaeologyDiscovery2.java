/*
https://school.programmers.co.kr/learn/courses/30/lessons/131702
        연습문제
        고고학 최고의 발견
*/

package normal;

import java.util.ArrayList;

public class BestArchaeologyDiscovery2 {

    boolean flag = true;
    int step = 0;
    ArrayList<ArrayList<int[][]>> list = new ArrayList<>();
    int minSum;

    public int solution(int[][] clockHands) {
        int len = clockHands.length;
        list.add(new ArrayList<>()); // step - 0;
        list.get(step).add(clockHands);
        minSum = checkZero(clockHands);
        if(minSum == 0){
            return 0;
        }

        while(flag){
            ArrayList<int[][]> stepArr = list.get(step);
            step++;
            list.add(new ArrayList<>());
            for (int[][] clockHand : stepArr) {
                if(!makeClockHand(clockHand, len)){
                    break;
                }
            }
        }

        return step;
    }

    private boolean makeClockHand(int[][] clockHand, int len) {

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if(clockHand[i][j] != 0){
                    int[][] result = addArrFind(clockHand, i, j, len);

                    int sum = checkZero(result);

                    if(sum == 0){
                        flag = false;
                    }
                    if(minSum > sum){
                        minSum = sum;
                        list.get(step).add(result);
                    }
                }
            }
        }

        return flag;
    }

    private int[][] addArrFind(int[][] clockHand,int x, int y, int len) {
        int[][] result = new int[len][len];
        int temp = (clockHand[x][y] + 1) % 4;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                result[i][j] = clockHand[i][j];
            }
        }
        for (int i = Math.max(x-1, 0); i < Math.min(x+2,len); i++) {
            result[i][y] = (result[i][y] + 1) % 4;
        }
        for (int i = Math.max(y-1, 0); i < Math.min(y+2,len); i++) {
            result[x][i] = (result[x][i] + 1) % 4;
        }
        result[x][y] = temp;

        return result;
    }

    private int checkZero(int[][] clockHands) {
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
        BestArchaeologyDiscovery2 bestArchaeologyDiscovery = new BestArchaeologyDiscovery2();
        int[][] clockHands = {{0,3,3,0}, {3,2,2,3}, {0,3,2,0}, {0,3,3,3}};

        // 0은 12시 방향, 1은 3시 방향, 2는 6시 방향, 3은 9시 방향
        int solution = bestArchaeologyDiscovery.solution(clockHands);
        System.out.println("solution = " + solution);
    }
}
