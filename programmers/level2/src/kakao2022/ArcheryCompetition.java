/*
https://school.programmers.co.kr/learn/courses/30/lessons/92342
        2022 KAKAO BLIND RECRUITMENT
        양궁대회
*/

package kakao2022;


public class ArcheryCompetition {
    boolean[] check = new boolean[11];
    int score = 0;
    int[] ryan = new int[11];
    int[] info2;
    int[] answer;

    public int[] solution(int n, int[] info) {
        answer = new int[11];
        info2 = info.clone();
        for (int i = 0; i < info.length; i++) {
            check[i] = ( info[i] != 0 );
        }
        makeRyanScore(0, n);
        return score==0 ? new int[]{-1} : answer;
    }

    private void makeRyanScore(int m, int n) {
        if(m == n){
            int nowScore = makeScore();
            if(score <= nowScore){
                score = nowScore;
                answer = ryan.clone();
            }
            return ;
        }
        for (int i = 0; i <= 10; i++) {
            ryan[i]++;
            makeRyanScore(m+1, n);
            ryan[i]--;
        }
    }

    private int makeScore() {
        int result = 0;
        for (int i = 0; i < 11; i++) {
            if(ryan[i] - info2[i] > 0){
                result += ( 10 - i );
            }else if(check[i]){
                result -= ( 10 - i ) ;
            }
        }
        return result;
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
