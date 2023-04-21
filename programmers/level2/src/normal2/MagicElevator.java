/*
https://school.programmers.co.kr/learn/courses/30/lessons/148653
        연습문제
        마법의 엘리베이터
*/
package normal2;


import java.util.Arrays;

public class MagicElevator {
    public int solution(int storey) {
        int answer = 0;

        int index = 0;

        while(storey > 0){
            storey--;
        }

        return 0;
    }
    public static void main(String[] args) {
        MagicElevator magicElevator = new MagicElevator();
        int solution = magicElevator.solution(16);
        System.out.println("solution = " + solution);
    }
}
