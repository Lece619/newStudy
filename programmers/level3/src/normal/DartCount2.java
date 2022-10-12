/*
https://school.programmers.co.kr/learn/courses/30/lessons/131129
            연습문제
            카운트 다운
*/
package normal;

import java.util.Arrays;

public class DartCount2 {
    public int[] solution(int target) {
        int[] answer = new int[2];
        int[][] findTarget = new int[2][100_061];
        Arrays.fill(findTarget[0], Integer.MAX_VALUE);
        findTarget[0][0] = 0;
        int[] step = new int[61];
        int[] singleBull = new int[61];

        makestep(step, singleBull);

        for (int i = 0; i <= target; i++) {
            makeNextStep(findTarget, i, step, singleBull);
        }

        answer[0] = findTarget[0][target];
        answer[1] = findTarget[1][target];
        return answer;
    }

    private void makeNextStep(int[][] findTarget, int idx, int[] step, int[] singleBull) {
        int nowStep = findTarget[0][idx];
        int nowBull = findTarget[1][idx];
        for (int i = 1; i < 61; i++) {
            int newStep = nowStep + step[i];
            int newSingle = nowBull + singleBull[i];
            if(findTarget[0][idx+i] > newStep){
                findTarget[0][idx+i] = newStep;
                findTarget[1][idx+i] = newSingle;
            } else if ( findTarget[0][idx+i] == newStep) {
                findTarget[1][idx + i] = Math.max(findTarget[1][idx+i], newSingle);
            }
        }
    }

    private void makestep(int[] step, int[] singleBull) {
        for (int i = 1; i < step.length; i++) {
            step[i] = 2;
            singleBull[i] = 0;
            if(i % 3 == 0){
                step[i] = 1;
            }
            if(i <= 40 && i % 2 == 0){
                step[i] = 1;
            }

            if(i <= 20){
                step[i] = 1;
                singleBull[i] = 1;
            }

            if(i == 50) {
                step[i] = 1;
                singleBull[i] = 1;
            }
        }
    }

    public static void main(String[] args) {
        DartCount2 dartCount = new DartCount2();
        System.out.println("dartCount.solution(21)[0] = " + dartCount.solution(58)[0]);
        System.out.println("dartCount.solution(21)[1] = " + dartCount.solution(58)[1]);
    }
}
