/*
https://school.programmers.co.kr/learn/courses/30/lessons/120868
        코딩테스트 입문
        삼각형의 완성조건 (2)
*/
package basic;

import java.util.Arrays;

public class Triangle {
    public int solution(int[] sides) {
        int sum = sides[0] + sides[1];
        int min = Math.max(sides[0], sides[1]) - Math.min(sides[0],sides[1]);
        return sum - min - 1;
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        triangle.solution(new int[]{6,11});
    }
}
