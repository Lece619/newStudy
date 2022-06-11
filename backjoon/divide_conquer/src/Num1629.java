//https://www.acmicpc.net/problem/1629
//백준 - 1629
//자연수 A를 B번 곱한 수를 알고 싶다. 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.

import java.util.Scanner;

public class Num1629 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        //dp = new int[b+1];
        a = a % c;
        System.out.println(divide(a, b, c));
    }

    public static long divide(long a, long b, long c) {
        if(b==1){
            return a;
        }else if(b%2==0){
            long newDivide = divide(a,b/2,c);
            return (newDivide*newDivide) % c ;
        }else{
            long newDivide = divide(a,b/2,c);
            return (newDivide*newDivide * a) % c ;
        }

    }
}
