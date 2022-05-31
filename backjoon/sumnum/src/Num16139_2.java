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
        int[][] strArr = new int['z'-'a'+1][str.length()];
        strArr[str.charAt(0)-'a'][0]=1;
        for (int i = 1; i < str.length(); i++) {
            int idx = str.charAt(i)-'a';
            for (int j = 0; j < strArr.length; j++) {
                strArr[j][i]+=strArr[j][i-1];
            }
            strArr[idx][i]++;
        }

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(start==0){
                sb.append(strArr[c-'a'][end]).append("\n");
            }else{
                sb.append(strArr[c-'a'][end]-strArr[c-'a'][start-1]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
