//https://www.acmicpc.net/problem/10986 
//백준 누적합
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//나머지가 같은것 끼리 찾아주면됨
//0 0 0 1 1 0 0 1 1
//==>2 로 나눴을때 나머지는 0 1
//0 인것들로 조합  1 인 것들로 조합 으로 누적합에서 계산하면 가능.
public class Num10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] count = new long[M];

        st = new StringTokenizer(br.readLine());
        int nowSum=0;
        for (int i = 0; i < N; i++) {
            nowSum = (nowSum+Integer.parseInt(st.nextToken())) % M;
            count[nowSum]++;
        }
        long total = count[0]; // 나머지가 0인 것들은 우선 추가
                                //나머지 원소들에 대해서는 조합으로 2개씩 뽑아주면 된다.(순서 상관X)
                                //conbination  !
        for (int i = 0; i < M; i++) {
            total+= (count[i]*(count[i]-1))/2;
        }
        System.out.println(total);

    }
}