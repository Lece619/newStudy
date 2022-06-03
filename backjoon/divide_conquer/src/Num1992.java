//https://www.acmicpc.net/problem/1992
//백준 - 쿼드 트리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1992 {

    static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        answer="";

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                arr[i][j]=Integer.parseInt(line[j]);
            }
        }
        compress(arr);
        System.out.println(answer);

    }
    //정답찾기
    public static void compress(int[][] arr){
        int checkPoint = checkArr(arr);
        if(checkPoint==3){
            answer+="(";
            compress(divideConquer(arr,0,0));
            compress(divideConquer(arr,0,1));
            compress(divideConquer(arr,1,0));
            compress(divideConquer(arr,1,1));
            answer+=")";
        }else{
            answer+=""+checkPoint;
        }

    }
    //분할
    public static int[][] divideConquer(int[][] arr,int x,int y){
        int length = arr.length/2;
        int[][] returnArr = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <length; j++) {
                returnArr[i][j] = arr[i+length*x][j+length*y];
            }
        }
        return  returnArr;
    }

    //확인 0압축이면 -> 0 1압축이면 1 압축불가면 3;
    public static int checkArr(int[][] arr){
        int sum = 0;
        int max = arr.length*arr.length;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                sum+=anInt;
            }
        }
        if(sum==0){
            return 0;
        }else if(sum==max){
            return 1;
        }else{
            return 3;
        }
    }
}
