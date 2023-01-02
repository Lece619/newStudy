/*
https://school.programmers.co.kr/learn/courses/30/lessons/147354
        연습문제
        테이블 해시 함수
*/

package normal2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TableHashFunction {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        ArrayList<int[]> table = new ArrayList<>(Arrays.asList(data));
        int standard = col - 1;

        table.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[standard] == o2[standard]){
                    return o2[0] - o1[0];
                }
                return o1[standard] - o2[standard];
            }
        });


        int answer = -1;

        for (int i = row_begin; i <= row_end; i++) {
            int[] tuple = table.get(i - 1);
            int s_i = 0;
            for (int num : tuple) {
                s_i += num % (i);
            }
            if(answer == -1){
                answer = s_i;
                continue;
            }
            answer = answer ^ s_i;
        }

        return answer;
    }

    public static void main(String[] args) {
        int num1 = 9;
        int num2 = 10;
        String num1Binary = Integer.toBinaryString(num1);
        String num2Binary = Integer.toBinaryString(num2);
        int num3 = num1 ^ num2;

        int[][] data = {{2,2,6}, {1,5,10}, {4,2,9}, {3,8,3}};
        int col = 2;
        int row_begin = 2;
        int row_end = 3;

        TableHashFunction tableHashFunction = new TableHashFunction();
        int solution = tableHashFunction.solution(data, col, row_begin, row_end);
        System.out.println("solution = " + solution);
    }
}
