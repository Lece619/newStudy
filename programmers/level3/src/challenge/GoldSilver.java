/*
https://school.programmers.co.kr/learn/courses/30/lessons/86053
        월간 코드 챌린지 시즌3
        금과 은 운반하기
*/
package challenge;

public class GoldSilver {

    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = 0;
        long rightTime = (long) ((a + b - 1) * Math.pow(10,5) * 2 + Math.pow( 10 , 5 ));
        long leftTime = 1;

        while(rightTime >= leftTime){
            long mid = (rightTime + leftTime) / 2;
            if( checkBuild(a, b, g, s, w, t, mid)){
                rightTime = mid - 1;
            }else{
                leftTime = mid + 1;
            }
        }
        answer = leftTime;

        return answer;
    }

    private boolean checkBuild(int a, int b, int[] g, int[] s, int[] w, int[] t, long time) {
        long totalG = 0;
        long totalS = 0;
        long total = 0;

        for (int i = 0; i < g.length; i++) {
            long oneWay = time / t[i];
            long count = oneWay % 2 == 0 ? oneWay / 2 : oneWay / 2 + 1;
            totalG += Math.min(w[i] * count, g[i]);
            totalS += Math.min(w[i] * count, s[i]);
            total += Math.min(w[i] * count, g[i] + s[i]);
        }

        return totalG >= a && totalS >= b && total >= a+b;

    }

    public static void main(String[] args) {
        int a = 90;
        int b = 500;
        int[] g = {70,70,0};
        int[] s = {0,0,500};
        int[] w = {100,100,2};
        int[] t = {4,8,1};
        GoldSilver goldSilver = new GoldSilver();
        long solution = goldSilver.solution(a, b, g, s, w, t);
        System.out.println("solution = " + solution);
    }
}
