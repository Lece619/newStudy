/*
* 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때,
*  이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.
* */

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Num10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Long,Integer> card = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            long key =Long.parseLong(st.nextToken());
            card.put(key,card.getOrDefault(key,0)+1);
        }
        br.readLine();
        st= new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            long key =Long.parseLong(st.nextToken());
            bw.write(card.getOrDefault(key,0)+" ");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
