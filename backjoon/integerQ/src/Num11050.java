/*
이항 계수 1
자연수 \(N\)과 정수 \(K\)가 주어졌을 때 이항 계수
\(\binom{N}{K}\)를 구하는 프로그램을 작성하시오.

 binomial coefficient
                    ( n )
                    ( k )
 */

import java.util.Scanner;

public class Num11050 {
    static int bc(int n, int k) {
        return factorial(n)/(factorial(n-k)*factorial(k));
    }
    static int factorial(int num){
        if(num<=1) return 1;
        return num*factorial(num-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int K=sc.nextInt();
        System.out.println(bc(N,K));
    }
}
