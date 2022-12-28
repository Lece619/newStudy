/*
https://school.programmers.co.kr/learn/courses/30/lessons/142085
        연습문제
        디펜스 게임
*/

package normal2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DefenceGame {

    public int solution(int n, int k, int[] enemy) {

        if(enemy.length == k){
            return k;
        }

        int maxIdx = enemy.length;
        int minIdx = 0;

        while(minIdx < maxIdx){

            int meanNum = ( minIdx + maxIdx ) / 2;

            int[] enemySizeMeanNum = makeSmall(enemy, meanNum);
            if(checkClear(n, enemySizeMeanNum , k)){
                minIdx = meanNum;
                continue;
            }

            maxIdx = meanNum - 1;

        }
        return maxIdx;
    }

    private boolean checkClear(int n, int[] enemySizeMeanNum, int k) {
        for (int i = 0; i < enemySizeMeanNum.length - k; i++) {
            n -= enemySizeMeanNum[i];
        }
        return n >= 0;
    }

    private int[] makeSmall(int[] enemy, int meanNum) {
        return Arrays.stream(enemy, 0, meanNum).sorted().toArray();
    }


    public static void main(String[] args) {
        DefenceGame defenceGame = new DefenceGame();
        int n = 7;
        int k = 7;
        int[] enemy = {4, 2, 4, 5, 3, 3, 1};

        int solution = defenceGame.solution(n, k, enemy);
        System.out.println("solution = " + solution);
    }
}
