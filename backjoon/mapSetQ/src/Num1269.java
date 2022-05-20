import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Num1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            setA.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            setB.add(Integer.parseInt(st.nextToken()));
        }
        for (Integer s : setB) {
            if(setA.contains(s)){
                n--;
            }
        }
        for (Integer s : setA) {
            if(setB.contains(s)){
                m--;
            }
        }
        //A-B B-A 합집합 - 교집합
        int result = m+n;
        bw.write(result);
        bw.flush();
        br.close();
        bw.close();
    }
}
