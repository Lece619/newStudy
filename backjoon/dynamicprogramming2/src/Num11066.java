import com.sun.org.apache.xpath.internal.operations.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/11066
//백준 알고리즘 - 파일 합치기
public class Num11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int Test = 0; Test < T; Test++) {
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            long[] file = new long[K];
            for (int i = 0; i < K; i++) {
                file[i] = Long.parseLong(st.nextToken());
            }




        }
    }
}
