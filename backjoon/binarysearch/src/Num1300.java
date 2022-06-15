//https://www.acmicpc.net/problem/1300
//백준알고리즘 - 이분탐색 - 1300

import java.util.Scanner;

public class Num1300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        //B[K] = x x=> 를 구해보자
        long min = 1;
        long max = K;

        while( min < max ){
            long mid = (min + max) /2;
            long count = 0;

            for (int i = 1; i <= N; i++) {
                count += Math.min( mid / i , N);
            }

            if( count >= K ){
                max = mid;
            }else{
                min = mid + 1;
            }

        }

        System.out.println(min);
    }
}
