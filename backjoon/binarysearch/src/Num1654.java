//https://www.acmicpc.net/problem/1654
//백준  - 랜선 자르기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[k];
        long maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i]=Long.parseLong(br.readLine());
            maxLen = Math.max(maxLen,arr[i]);
        }
        long answer = 0 ;
        long min = 0;
        maxLen++;

        while(min <= maxLen){
            long count = 0;
            answer= (min+maxLen) / 2;
            for (long i : arr) {
                count += ( i / answer );
            }

            if(count >= n){
                min = answer + 1;
            }else {
                maxLen = answer-1;
            }
        }

        System.out.println(maxLen);
    }
}
