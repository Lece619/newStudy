//https://www.acmicpc.net/problem/2805
//백준 - 나무자르기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Num2805 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M  = Long.parseLong(st.nextToken());
        st  = new StringTokenizer(br.readLine());
        long[] trees = new long[N];
        long max = 0;

        for (int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(st.nextToken());
            max = Math.max(trees[i],max);
        }

        long min = 0;
        long answer = 0;
        max++;

        while(min <= max){
            answer = ( min + max ) / 2;
            long len = 0L;
            for (long tree : trees) {
                long temp = tree - answer;
                len = temp > 0 ? temp + len : len ;
            }
            if( len >= M){
                min = answer + 1;
            }else{
                max = answer - 1;
            }
        }
        System.out.println(max);
    }
}
