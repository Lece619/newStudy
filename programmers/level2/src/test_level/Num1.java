package test_level;

import java.util.Arrays;

public class Num1 {
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int len = A.length;
        for (int i = 0; i < A.length; i++) {
            answer += A[i]*B[len-i-1];
        }
        return answer;
    }

    public static void main(String[] args) {
        Num1 num1 = new Num1();
        int[] A = {1,4,2};
        int[] B = {5,4,4};
        int solution = num1.solution(A, B);
        System.out.println("solution = " + solution);
    }
}
