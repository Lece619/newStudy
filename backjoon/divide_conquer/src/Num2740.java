import java.io.*;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2740
//분할정복 - 행렬 곱셈 
//일반 행렬곱으로 풀이함 
//분할정복으로 재 풀이 필요 스트라센 알고리즘 (Strassen Alogrithm) 사용
public class Num2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j]  = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] B = new int[M][K];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] C = new int[N][K];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {

                for (int k = 0; k < M; k++) {
                    C[i][j] += A[i][k]*B[k][j];
                }
                bw.write(C[i][j]+" ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
