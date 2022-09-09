/*
https://school.programmers.co.kr/learn/courses/30/lessons/12936
        연습문제
        줄 서는 방법
*/
package normal;


import java.util.ArrayList;

public class MakeLine {

    ArrayList<Integer> arrayList = new ArrayList<>();
    long[] fac;

    public int[] solution(int n, long k) {
        fac = new long[n];

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            fac[i] = factorial(i);
            arrayList.add(i+1);
        }
        int idx = 0;
        k--;
        for (int i = n-1; i >= 0; i--) {

            int find = (int) (k / fac[i]);

            k = k % fac[i];
            System.out.println("find = " + find);
            answer[idx++] = arrayList.get(find);
            System.out.println("arrayList = " + arrayList);
            arrayList.remove(find);
        }

        return answer;
    }

    private long factorial(int i) {
        if(i == 0 || i ==1){
            return 1;
        }
        return i * factorial( i - 1 );
    }


    public static void main(String[] args) {
        int n = 3;
        long k = 3;
        //123 132 213 231 312 321
        MakeLine makeLine = new MakeLine();
        int[] solution = makeLine.solution(n, k);
        for (int i : solution) {
            System.out.println("i = " + i);
        }

    }
}
