/*
https://school.programmers.co.kr/learn/courses/30/lessons/131701
        연습문제
        연속 부분 수열 합의 개수
*/

package normal;

import java.util.HashSet;

public class ContinuityNum {
    public int solution(int[] elements) {
        HashSet<Integer> sumNum = new HashSet<>();
        int length = elements.length;
        for (int i = 1; i < length + 1; i++) {
            for (int j = 0; j < length; j++) {
                int sum = 0;
                for (int k = 0; k < i; k++) {
                    sum += elements[(j + k) % length];
                }
                sumNum.add(sum);
            }
        }
        return sumNum.size();
    }

    public static void main(String[] args) {
        int[] elements = {7,9,1,1,4};
        ContinuityNum continuityNum = new ContinuityNum();
        continuityNum.solution(elements);
    }
}
