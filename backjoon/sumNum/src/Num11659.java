import java.io.*;
import java.util.StringTokenizer;

public class Num11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st=new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int sum = 0;
            for (int j = start-1; j <end; j++) {
                sum+=arr[j];
            }
            bw.write(sum+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
