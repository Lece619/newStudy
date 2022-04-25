/*
재원이는 한 도시의 시장이 되었다. 이 도시에는 도시를 동쪽과 서쪽으로 나누는 큰 일직선 모양의 강이 흐르고 있다.
 하지만 재원이는 다리가 없어서 시민들이 강을 건너는데 큰 불편을 겪고 있음을 알고 다리를 짓기로 결심하였다.
 강 주변에서 다리를 짓기에 적합한 곳을 사이트라고 한다.
 재원이는 강 주변을 면밀히 조사해 본 결과 강의 서쪽에는 N개의 사이트가 있고 동쪽에는 M개의 사이트가 있다는 것을 알았다. (N ≤ M)
 */

import java.io.*;
import java.util.StringTokenizer;

public class Num1010 {
    static int[][] bridge=new int[31][31];
//    m n combination
    static int combination(int m,int n){
        if(m==n||n==0) return 1;
        if(bridge[m][n]!=0) return bridge[m][n];
        return bridge[m][n]=combination(m-1,n)+combination(m-1,n-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int num=Integer.parseInt(br.readLine());
        for(int i=0;i<num;i++){
            st=new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());
            bw.write(combination(M,N)+"\n");
        }
        bw.flush();
        bw.close();
    }
}
