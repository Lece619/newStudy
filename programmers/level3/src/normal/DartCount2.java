/*
https://school.programmers.co.kr/learn/courses/30/lessons/131129
        연습문제
        카운트 다운
*/
package normal;

public class DartCount2 {
    public int[] solution(int target) {
        int[] answer = new int[2];
        int[][] findTarget = new int[100_061][2];
        int[] step = new int[61];
        int[] singleBull = new int[61];

        makestep(step, singleBull);

        for (int i = 0; i <= target; i++) {
            makeNextStep(findTarget, i, step, singleBull);
        }
        return answer;
    }

    private void makeNextStep(int[][] findTarget, int idx, int[] step, int[] singleBull) {
        int nowStep = findTarget[idx][0];
        int nowBull = findTarget[idx][1];
        for (int i = 1; i < 61; i++) {

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
