/*
https://school.programmers.co.kr/learn/courses/30/lessons/92342
        2022 KAKAO BLIND RECRUITMENT
        양궁대회
*/

package kakao2022;


import java.util.Arrays;

public class ArcheryCompetition2 {
    boolean[] check = new boolean[11];
    int score = 0;
    int[] info2;
    int[] answer;

    public int[] solution(int n, int[] info) {
        answer = new int[11];
        info2 = info.clone();
        for (int i = 0; i < info.length; i++) {
            check[i] = ( info[i] != 0 );
        }
        makeRyanScore(0, n , 10);
        for (int i = 0; i < answer.length; i++) {
            answer[i] = - (answer[i] - info[i]);
        }
        return score==0 ? new int[]{-1} : answer;
    }

    private void makeRyanScore(int m, int n, int limit) {
        if(m == n){
            int nowScore = makeScore();
            if(score < nowScore){
                score = nowScore;
                answer = info2.clone();
            }
            return ;
        }
        for (int i = limit; i >= 0; i--) {
            if(info2[i] > -1) {
                info2[i]--;
                makeRyanScore(m + 1, n, i);
                info2[i]++;
            }
        }
    }

    private int makeScore() {
        int result = 0;
        for (int i = 10; i >= 0; i--) {
            if(info2[i] < 0){
                result += ( 10 - i );
            }else if(check[i]){
                result -= ( 10 - i ) ;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArcheryCompetition2 archeryCompetition = new ArcheryCompetition2();
        int n = 9;
        int[] info = {0,0,1,2,0,1,1,1,1,1,1};

        int[] answer = archeryCompetition.solution(n, info);
        int idx = 0;
        for (int i : answer) {
            System.out.println( idx++ + " i = " + i);
        }
    }
}
