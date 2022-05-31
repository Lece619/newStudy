//https://www.acmicpc.net/problem/2630  색종이 만들기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num2630 {
    static int white = 0;
    static int blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arrNum = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arrNum[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        /*System.out.println(white);
        for (int[] ints : arrNum) {
            System.out.println();
            for (int anInt : ints) {
                System.out.print(anInt);
            }
        }*/
        dAndC(arrNum,N);
        System.out.println(white);
        System.out.println(blue);

    }
    public static void dAndC(int[][] arrInt, int n){
        if(n==1){
            if(arrInt[0][0]==1){
                blue++;
            }else{
                white++;
            }
        }else{
            int sum=0;
            for (int[] ints : arrInt) {
                for (int anInt : ints) {
                    sum+=anInt;
                }
            }
            if(sum==n*n){
                blue++;
            }else if(sum==0){
                white++;
            }else{
                dAndC(divideArr(arrInt,n,0,0),n/2);
                dAndC(divideArr(arrInt,n,0,1),n/2);
                dAndC(divideArr(arrInt,n,1,0),n/2);
                dAndC(divideArr(arrInt,n,1,1),n/2);
            }
        }
    }
    public static int[][] divideArr(int[][] arrInts, int n, int x, int y){
        int startX = x*n/2;
        int startY = y*n/2;
        int rangeX = n/2+x*n/2;
        int rangeY = n/2+y*n/2;
        int[][] arr =new int[n/2][n/2];
        for (int i = x*n/2; i < n/2+x*n/2 ; i++) {
            for (int j = y*n/2; j < n/2+y*n/2; j++) {
                arr[i-x*n/2][j-y*n/2] = arrInts[i][j];
            }
        }
        return arr;
    }
}
