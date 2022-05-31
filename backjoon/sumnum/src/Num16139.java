//https://www.acmicpc.net/problem/16139  인간-컴퓨터 상호작용

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Num16139 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        long q = sc.nextInt();
        Map<String,int[]> map = new HashMap<>();
        IntStream.range(0,str.length()).forEach(i->map.put(str.charAt(i)+"",new int[str.length()]));
        map.get(str.charAt(0)+"")[0]++;
        for (int i = 1; i < str.length(); i++) {
            for (String s : map.keySet()) {
                map.get(s)[i]+=map.get(s)[i-1];
            }
            map.get(str.charAt(i)+"")[i]+=map.get(str.charAt(i)+"")[i-1]+1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String c = sc.next();
            int start = sc.nextInt();
            int end = sc.nextInt();

            sb.append(
                    (map.get(c)[end]-map.get(c)[start])
                    +"\n");
        }
        System.out.println();
        System.out.println(map.get("a")[6]);
        System.out.println();
        System.out.println(sb.toString());
    }
}
