/*총 N개의 문자열로 이루어진 집합 S가 주어진다.
입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는 것이
총 몇 개인지 구하는 프로그램을 작성하시오.
*
* */


import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Num14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        for(int i = 0; i < m; i++){
            if(set.contains(br.readLine())){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
