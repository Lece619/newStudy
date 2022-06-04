
//https://www.acmicpc.net/problem/1920
//백준 - 수찾기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[N];
        //Set 을 사용하는게 제일 편하겠지만 Binary Search  구현
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //배열 정렬
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int targerNum = Integer.parseInt(st.nextToken());
            sb.append(binary(arr,targerNum,0,N-1)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static int binary(int[] arr, int targetNum,int start,int end){
        /*
        *   0  3   -> 1  01   23
        *   0  4   -> 2  012  34
        * */
        if(start > end){
            return 0;
        }
        int mid = (start + end) / 2;

        if(arr[mid] == targetNum){
            return 1;
        }else if(arr[mid] > targetNum){
            return binary(arr,targetNum,start,mid-1);
        }else{
            return binary(arr,targetNum,mid+1,end);
        }
    }
}
