/*
https://school.programmers.co.kr/learn/courses/30/lessons/42895
        동적계획법(Dynamic Programming)
        N으로 표현
*/

package dynamicprogramming;

import java.util.*;

public class ExpressN2 {

    public int solution(int N, int number) {

        List<Set<Integer>> setArr =new ArrayList<>();
        setArr.add(new HashSet<>());

        for (int i = 1; i < 9; i++) {
            setArr.add(new HashSet<>());
            setArr.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
            for (int j = 1; j < i; j++) {
                int k = i - j;
                makeLists(setArr, i, j, k);
            }
        }

        for (int i = 1; i < setArr.size(); i++) {
            Set<Integer> integers = setArr.get(i);
            if (integers.contains(number)) {
                return i;
            }
        }
        return -1;
    }

    private void makeLists(List<Set<Integer>> listArr, int n, int num1, int num2) {

        Set<Integer> targetSet = listArr.get(n);
        Set<Integer> num1Set = listArr.get(num1);
        Set<Integer> num2Set = listArr.get(num2);

        for (Integer n1 : num1Set) {
            for (Integer n2 : num2Set) {
                targetSet.add(n1 + n2);
                targetSet.add(n1 - n2);
                targetSet.add(n1 * n2);
                if(n2 != 0) {
                    targetSet.add(n1 / n2);
                }
            }
        }

    }

    public static void main(String[] args) {
        int N = 4;
        int number = 31;
        ExpressN2 expressN = new ExpressN2();
        int solution = expressN.solution(N, number);
        System.out.println();
        System.out.println("solution = " + solution);
    }
}
