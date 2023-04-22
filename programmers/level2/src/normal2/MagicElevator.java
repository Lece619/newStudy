/*
https://school.programmers.co.kr/learn/courses/30/lessons/148653
        연습문제
        마법의 엘리베이터
*/
package normal2;


import java.util.Arrays;

public class MagicElevator {

    int nowStory;
    public int solution(int storey) {
        int answer = 0;

        nowStory = storey;

        while(nowStory > 0){
            answer += makeNextStory();
        }

        return answer;
    }

    private long makeNextStory() {

        int remain = nowStory % 10;

        int upCount = 10 - remain;
        int downCount = remain;

        int upStory = (nowStory + (10 - remain)) / 10;
        int downStory = (nowStory - remain) / 10;

        upCount += nextRemain(upStory);
        downCount += nextRemain(downStory);

        if(upCount < downCount){
            nowStory = upStory;
            return 10 - remain;
        }

        nowStory = downStory;
        return remain;
    }

    private int nextRemain(int story) {
        int remain = story % 10;
        return Math.min(remain, 10 - remain);
    }

    public static void main(String[] args) {
        MagicElevator magicElevator = new MagicElevator();
        int solution = magicElevator.solution(16);
        System.out.println("solution = " + solution);
    }
}
