/*
* pokemon
* */

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Num1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //pokemon num  = n
        //question num = m
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String,String> map = new HashMap<>();
        for(int i = 1;i < n+1;i++){
            String pokemonName = br.readLine();
            map.put(i+"",pokemonName);
            map.put(pokemonName,i+"");
        }
        for(int i = 0;i < m;i++){
            String find = br.readLine();
            bw.write(map.get(find)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
