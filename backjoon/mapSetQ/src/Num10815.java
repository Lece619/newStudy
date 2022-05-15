/*  숫자 카드는 정수 하나가 적혀져 있는 카드이다
*  . 상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는
*   숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.
*
* */

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Num10815 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer,Integer> map = new HashMap<>();
        String result="";
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            map.put(Integer.parseInt(st.nextToken()),1);
        }

       // int m = sc.nextInt();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            bw.write(map.getOrDefault(Integer.parseInt(st.nextToken()),0)+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
