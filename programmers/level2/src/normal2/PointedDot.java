/*
https://school.programmers.co.kr/learn/courses/30/lessons/140107
        연습문제
        점 찍기
*/

package normal2;

public class PointedDot {
    public long solution(int k, int d) {
        long answer = 0;

        for (long i = 0; i <= d; i += k) {
            long maxY = findY(i, d);
            answer += maxY/k + 1;
        }

        return answer;
    }

    private long findY(long i, long d) {
        return (long) Math.sqrt(d * d - i * i);
    }

    public static void main(String[] args) {
        PointedDot pointedDot = new PointedDot();
        long solution = pointedDot.solution(1, 5);
        System.out.println("solution = " + solution);
    }
}
