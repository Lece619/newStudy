/*
https://school.programmers.co.kr/learn/courses/30/lessons/17682
        2018 KAKAO BLIND RECRUITMENT
        [1차] 다트 게임
*/

package kakao2018;

import java.util.Arrays;

public class DartGame {

    public int solution(String dartResult) {
        int answer = 0;
        String score = dartResult.replaceAll("[SDT*#]"," ").replaceAll(" {2,}"," ");
        String option = dartResult.replaceAll("\\d{1,}"," ").trim();
        System.out.println("option = " + option);

        int[] scoreInt = Arrays.stream(score.split(" ")).mapToInt((Integer::parseInt)).toArray();
        String[] s = option.split(" ");

        for (int i = 0; i < s.length; i++) {
            makeScore(scoreInt, s[i], i);
        }

        for (int i : scoreInt) {
            answer += i;
        }
        return answer;
    }

    private void makeScore(int[] scoreInt, String s, int idx) {
        char squared = s.charAt(0);

        if(squared=='D'){
            scoreInt[idx] = (int) Math.pow(scoreInt[idx],2);
        }
        if(squared=='T'){
            scoreInt[idx] = (int) Math.pow(scoreInt[idx],3);
        }

        int option = 1;
        if(s.contains("#")){
            option = -1;
            scoreInt[idx] *= (-1);
        }else if(s.contains("*")){
            if(idx==0){
                scoreInt[idx] *= 2;
            }else{
                scoreInt[idx] *= 2;
                scoreInt[idx-1] *= 2;
            }
        }
    }

    public static void main(String[] args) {
        String dartResult = "1D2S#10S";
        int answer = new DartGame().solution(dartResult);
        System.out.println("answer = " + answer);
    }
}
