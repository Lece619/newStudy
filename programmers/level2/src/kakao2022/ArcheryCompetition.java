/*
https://school.programmers.co.kr/learn/courses/30/lessons/92342
        2022 KAKAO BLIND RECRUITMENT
        양궁대회
*/

package kakao2022;

public class ArcheryCompetition {
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        int[] score = new int[11];
        

        return answer;
    }

    public static void main(String[] args) {
        ArcheryCompetition archeryCompetition = new ArcheryCompetition();
        int n = 5;
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};

        int[] answer = archeryCompetition.solution(n, info);
        int idx = 0;
        for (int i : answer) {
            System.out.println( idx++ + " i = " + i);
        }
    }
}
