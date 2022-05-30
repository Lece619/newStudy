//https://www.acmicpc.net/problem/16139  인간-컴퓨터 상호작용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num16139_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] strArr = new int[str.length()][str.length()];
        strArr[0][0]=1;
        for (int i = 1; i < str.length(); i++) {
            for (int[] ints : strArr) {
                ints[i]+=ints[i-1];
            }
            int a = str.indexOf(str.charAt(i));
            strArr[a][i]++;
        }

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String c = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            start = start == 0 ? 0 : strArr[str.indexOf(c)][start-1];
            end = end == 0 ? 0 : strArr[str.indexOf(c)][end];
            sb.append((end-start)+"\n");
        }
        System.out.println(sb.toString());
    }
}
