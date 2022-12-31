/*
https://school.programmers.co.kr/learn/courses/30/lessons/142085
        연습문제
        디펜스 게임
*/

package normal2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class DefenceGame2 {

    public int solution(int n, int k, int[] enemy) {

        PriorityQueue<Integer> invincibility = new PriorityQueue<>();
        int totalSum = 0;
        int invincibilitySum = 0;

        int index = 0;
        for ( index = 0; index < enemy.length; index++) {
            totalSum += enemy[index];
            invincibilitySum += enemy[index];
            invincibility.add(enemy[index]);
            if(invincibility.size() > k){
                invincibilitySum -= invincibility.poll();
            }

            if(totalSum - invincibilitySum > n){
                break;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        DefenceGame2 defenceGame = new DefenceGame2();
        int n = 7;
        int k = 7;
        int[] enemy = {4, 2, 4, 5, 3, 3, 1};

        int solution = defenceGame.solution(n, k, enemy);
        System.out.println("solution = " + solution);
    }
}
