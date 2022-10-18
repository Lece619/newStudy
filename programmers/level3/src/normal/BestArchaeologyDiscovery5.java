/*
https://school.programmers.co.kr/learn/courses/30/lessons/131702
        연습문제
        고고학 최고의 발견
*/

package normal;


import java.util.ArrayList;

public class BestArchaeologyDiscovery5 {


    public int solution(int[][] clockHands) {

        int answer = 0;

        int[][] clockArr = new int[clockHands.length + 2][clockHands.length + 2];

        return answer;
    }



    public static void main(String[] args) {
        BestArchaeologyDiscovery5 bestArchaeologyDiscovery = new BestArchaeologyDiscovery5();
        int[][] clockHands = {{0, 3, 3, 0}, {3, 2, 2, 3}, {0, 3, 2, 0}, {0, 3, 3, 3}};

        // 0은 12시 방향, 1은 3시 방향, 2는 6시 방향, 3은 9시 방향
        int solution = bestArchaeologyDiscovery.solution(clockHands);
        System.out.println("solution = " + solution);
    }
}
