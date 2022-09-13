/*
https://school.programmers.co.kr/learn/courses/30/lessons/92342
        2022 KAKAO BLIND RECRUITMENT
        양궁대회
*/

package kakao2022;


import java.util.HashSet;

public class ArcheryCompetition {

    boolean[] check = new boolean[11];
    int[] win = new int[11];
    public int[] solution(int n, int[] info) {

        makeRyanScore(0, n, 5);
        return null;
    }

    private void makeRyanScore(int num, int n, int limit) {
        if(num == n){
            for (int i : win) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for (int i = limit; i >= 0; i--) {
            System.out.println("i = " + i);
            win[i]++;
            makeRyanScore(num+1 , n, i);
            win[i]--;
        }
    }


    public static void main(String[] args) {
        ArcheryCompetition archeryCompetition = new ArcheryCompetition();
        int n = 5;
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};

        int[] answer = archeryCompetition.solution(n, info);
        int idx = 0;

        HashSet<Integer[]> set = new HashSet<>();
        Integer[] a = {1,2};
        Integer[] b = {1,2};
    }
}
