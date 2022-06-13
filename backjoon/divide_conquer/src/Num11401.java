//https://www.acmicpc.net/problem/11401
//백준 알고리즘 -이항 계수 3

import java.util.Scanner;

public class Num11401 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n = sc.nextInt();
        k = sc.nextInt();
        System.out.println(combi(n,k));
    }

    public static int combi(int n, int k){
        if(n==k||k==0) return 1;
        return (combi(n-1,k) + combi(n-1, k-1))% 1000000007;
    }
}
