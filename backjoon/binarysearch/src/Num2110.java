import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2110
// 백준 - 이분탐색 - 공유기 설치
public class Num2110 {
    static long[] house;
    static int c ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        house = new long[n];

        for (int i = 0; i < n; i++) {
            house[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(house);

        long start = 1;
        long end = house[house.length-1]-house[0] +1;
        long answer = 0;
        ArrayList<Long> total = new ArrayList<>();

        while(start<end){
            answer = (start+end) / 2 ;
            int find = findNum(answer);
            if(c <= find){
                start = answer+1;
            }else{
                end = answer;
            }
        }
        System.out.println(start-1);
    }
    //최대 거리가  max 일 때 집과의 거리가 그 이상인 것들의 모음 .
    public static int findNum(long max){
        int count = 1;
        int initIdx = 0;
        int nextIdx = 1;
        while(nextIdx < house.length){
            if(house[nextIdx]-house[initIdx] >= max ){
                count++;
                initIdx = nextIdx;
                nextIdx++;
            }else{
                nextIdx++;
            }
        }

        return count;
    }
}
