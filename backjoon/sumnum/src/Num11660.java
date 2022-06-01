//https://www.acmicpc.net/problem/11660
//백준 - 구간 합 구하기 5
import java.io.*;
import java.util.StringTokenizer;

public class Num11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //x1 x2 y1 y2 크기순이면
        //x1 y1 - (x1 ,y2-1)  - (x2-1,y1) + (x1-1,y2-1) 더한넓이.
        int[][] nums = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            int rowNum = 0;
            for (int j = 1; j < N+1; j++) {
                rowNum=rowNum+Integer.parseInt(st.nextToken());
                nums[i][j] = nums[i-1][j]+rowNum;
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1, x2, y1, y2, bigX,smallX,bigY,smallY, size;
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            bigX = Math.max(x1,x2);
            bigY = Math.max(y1,y2);
            smallX = Math.min(x1,x2)-1;
            smallY = Math.min(y1,y2)-1;
            size = nums[bigX][bigY]-nums[bigX][smallY]-nums[smallX][bigY]+nums[smallX][smallY];
            bw.write(size+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
