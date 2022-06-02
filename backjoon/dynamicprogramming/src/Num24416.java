//https://www.acmicpc.net/problem/24416
//백준 :  알고리즘 수업 - 피보나치 수 1

import java.util.Scanner;

public class Num24416 {
    /*
    너무 단순한 코딩.

    static int dpCnt = 0;
    static int reCnt = 0;
    static int dp[];

    public static int fiboNormal(int n){
        if(n<3){
            return 1;
        }else{
            reCnt++;
            return fiboNormal(n-1) + fiboNormal(n-2);
        }
    }
    public static int fiboDp(int n){
        if(dp[n]!=0){
            return dp[n];
        }else{
            dpCnt++;
            return dp[n]=fiboDp(n-1)+fiboDp(n-2);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp=new int[N+1];
        dp[1]=1;
        dp[2]=1;
        fiboNormal(N);
        fiboDp(N);
        reCnt++;
        System.out.println(reCnt+" "+dpCnt);
    }*/

    //dp 로 해결할경우 . 자기 자신  -2개가 새로 호출되는 함수수.
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp = n-2;
        int num1 = 0;
        int num2 = 2;
        int num3 = 3;

        // n 5이후는
        for (int i = 5; i < n+1 ; i++) {
            num1 = num2;
            num2 = num3;
            num3 = num1+num2;
        }
        System.out.println(num3 + " " + dp);
    }
}
