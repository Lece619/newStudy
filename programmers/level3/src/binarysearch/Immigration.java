/*
https://school.programmers.co.kr/learn/courses/30/lessons/43238
        이분탐색
        입국심사
*/

package binarysearch;

public class Immigration {

    public long solution(int n, int[] times) {
        long answer = 0;
        long maxTime = 1_000_000_000L * 1_000_000_000;
        long minTime = 1;

        while( maxTime > minTime){
            long targetTime = (maxTime + minTime ) / 2;
            if( findTime ( targetTime, n, times)){
                maxTime = targetTime;
            }else{
                minTime = targetTime + 1;
            }
        }

        return minTime;
    }

    private boolean findTime(long targetTime, int n, int[] times) {

        long sum = 0;

        for (int time : times) {
            sum += targetTime / time;
        }
        System.out.println("sum = " + sum);
        System.out.println("n = " + n);
        return n <= sum;
    }

    public static void main(String[] args) {
        Immigration immigration = new Immigration();
        int n = 6;
        int[] times = {7, 10};
        System.out.println("immigration.solution() = " + immigration.solution(n, times));
    }
}
