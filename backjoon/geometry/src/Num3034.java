import java.io.*;
import java.util.StringTokenizer;

public class Num3034 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int max = r*r + c*c;
        for (int i = 0; i < n; i++) {
            int match = Integer.parseInt(br.readLine());
            if(max>=match*match){
                bw.write("DA\n");
            }else{
                bw.write("NE\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
