//https://www.acmicpc.net/problem/11401
//백준 알고리즘 -이항 계수 3

import java.util.Scanner;

public class Num11401 {
    static long p = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n = sc.nextInt();
        k = sc.nextInt();
        //c(n k)  =  n! /  k!(n-k)!
        long nFac = fac(n);
        long knFac = fac(k) * fac(n-k) % p;

        System.out.println( ( nFac * pow(knFac,p-2) ) % p );

    }

    public static long fac(long num){
        long facNum = 1L;
        while(num>1){
            facNum = facNum * num % p;
            num--;
        }
        return facNum;
    }

    public static long pow(long num, long powNum){
        long result = 1L;

        while(powNum>0){

            if(powNum % 2 == 1){
                result = (result * num ) % p;
            }

            num = ( num * num ) % p;
            powNum /= 2;
        }

        return result;  
    }

}
