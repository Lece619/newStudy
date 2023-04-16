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
        int[] floors = new StringBuilder().append(storey).reverse()
                .chars().mapToObj(i->(char)i)
                .mapToInt((i -> Integer.parseInt(String.valueOf(i)))).toArray();

        for (int i = 0; i < floors.length - 1; i++) {
            int nowFloor = floors[i];
            int nextFloor = floors[i + 1];

            int nowDown = nowFloor + Math.min(nextFloor, 10 - nextFloor);
            int nowUp = 10 - nowFloor  + Math.min(nextFloor + 1, 10 - (nextFloor + 1));

            if(nowDown < nowUp){
                answer += nowFloor;
                continue;
            }

            answer = 10 - nowFloor;

        }


        //dp를 사용한 알고리즘 필요
        return 0;
    }
    public static void main(String[] args) {
        MagicElevator magicElevator = new MagicElevator();
        int solution = magicElevator.solution(16);
        System.out.println("solution = " + solution);
    }
}
