/*김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.


 * */

import java.io.*;
import java.util.*;

public class Num1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String,Boolean> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            map.put(br.readLine(),true);
        }
        for (int i = 0; i < m; i++) {
            String check = br.readLine();
            if(map.getOrDefault(check,false)){
                cnt++;
                set.add(check);
            }
        }
        Collections.sort(new ArrayList<>(set));
        String[] sortedKey = set.toArray(new String[0]);
        Arrays.sort(sortedKey);
        bw.write(cnt+"\n");
        for (String s : sortedKey) {
            bw.write(s+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
        System.out.println(sortedKey.toString());
        System.out.println(set);
    }
}
