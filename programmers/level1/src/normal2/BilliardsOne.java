/*
https://school.programmers.co.kr/learn/courses/30/lessons/169198
        연습문제
        당구 연습
*/

package normal2;


import java.util.Arrays;

public class BilliardsOne {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        Arrays.fill(answer, Integer.MAX_VALUE);
        for (int i = 0; i < balls.length; i++) {
            int[] ball = balls[i];

            int[] ball1 = new int[]{-ball[0], ball[1]};
            int[] ball2 = new int[]{ball[0], -ball[1]};
            int[] ball3 = new int[]{m + (m - ball[0]), ball[1]};
            int[] ball4 = new int[]{ball[0], n + (n - ball[1])};

            if(startX == ball[0]){
                if(startY > ball[1]){
                    ball2 = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
                }else{
                    ball4 = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
                }
            }

            if(startY == ball[1]){
                if(startX > ball[0]){
                    ball1 = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
                }else{
                    ball3 = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
                }
            }

            answer[i] = (int) Math.min(answer[i],getPowRoot(startX, startY, ball1));
            answer[i] = (int) Math.min(answer[i],getPowRoot(startX, startY, ball2));
            answer[i] = (int) Math.min(answer[i],getPowRoot(startX, startY, ball3));
            answer[i] = (int) Math.min(answer[i],getPowRoot(startX, startY, ball4));

        }
        return answer;
    }

    private double getPowRoot(int startX, int startY, int[] ball) {
        return Math.pow(startX - ball[0], 2) + Math.pow(startY - ball[1], 2);
    }

    public static void main(String[] args) {
        BilliardsOne billiardsOne = new BilliardsOne();
        int m  = 10;
        int n = 10;
        int startX = 3;
        int startY = 7;
        int[][] balls = {{7, 7}, {2, 7}, {7, 3}};

        int[] solution = billiardsOne.solution(m, n, startX, startY, balls);
        for (int i : solution) {

            System.out.println("i = " + i);

        }
    }
}
