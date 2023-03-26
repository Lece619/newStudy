/*
https://school.programmers.co.kr/learn/courses/30/lessons/161989
        연습문제
        덧칠하기
*/

package normal2;

public class OverRiding {

    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int nowPaint = 0;
        for (int needPaint : section) {
            if(needPaint > nowPaint){
                answer++;
                nowPaint = needPaint + m - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 8;
        int m = 4;
        int[] section = {2, 3, 6};

        OverRiding overRiding = new OverRiding();
        int solution = overRiding.solution(n, m, section);
        System.out.println("solution = " + solution);
    }
}
