// Q.이항계수  binomial coefficient 2
//
// 자연수 \(N\)과 정수 \(K\)가 주어졌을 때 이항 계수
//        \(\binom{N}{K}\)를 10,007로 나눈 나머지를 구하는 프로그램을 작성하시오.
//        \(\binom{N}{K}\)를 10,007로 나눈 나머지를 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Num11051 {
    static int[][] combi=new int[1001][1001];
    static int combination(int n,int k){
        if(n==k || k==0) return 1;
        if(combi[n][k]!=0) return combi[n][k];
        return combi[n][k]=(combination(n-1,k-1)+combination(n-1,k))%10007;
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N=sc.nextInt();
        int K=sc.nextInt();
        System.out.println(combination(N,K));
    }

          //런타임에러
//        public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n=sc.nextInt();
//        int k=sc.nextInt();
//        int c=n-k;
//        int lastN=1;
//        int lastK=1;
//        for(int i=n;i>c;i--){
//            lastN=(lastN*i);
//        }
//        for(int i=1;i<=k;i++){
//            lastK=(lastK*i);
//        }
//        System.out.println((lastN/lastK)%10007);
//    }
        //Dp
//    private static int combination(int n, int k) {
//        if (n == k || k == 0) {
//            return 1;
//        } else {
//            return combination(n - 1, k - 1) + combination(n - 1, k);
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//        System.out.println(combination(n, k));
//    }
}
