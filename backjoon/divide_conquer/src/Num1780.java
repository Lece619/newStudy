//https://www.acmicpc.net/problem/1780
//백준 - 분할정복 - 종이의 개수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1780 {
    public static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        answer = new int[3];
        int n = Integer.parseInt(br.readLine());
        int[][] numArr = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                numArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        find(numArr);
        for (int i : answer) {
            System.out.println(i);
        }
    }
    
    //분할 재귀함수
    public static void find(int[][] arrNum){
        if(arrNum.length==1){
            answer[arrNum[0][0]+1]++;
        }else if(check(arrNum)){
            answer[arrNum[0][0]+1]++;
        }else{
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    find(devideArr(arrNum,i,j));
                }
            }
        }
    }
    //x ,y 인덱스에 따른 배열 분할
    public static int[][] devideArr(int[][] arrNum,int x,int y){
        int size = arrNum.length/3;
        int[][] returnArr = new int[size][size];
        int indexX = 0;
        int indexY = 0;
        for (int i = size*x; i < size*x + size; i++) {
            indexY=0;
            for (int j = size*y; j < size*y + size; j++) {
                returnArr[indexX][indexY++] = arrNum[i][j];
            }
            indexX++;
        }
        return returnArr;
    }

    //배열이 -1, 0, 1 로 이루어져 있는지 확인
    public static boolean check(int[][] arrNum){
        int stadard = arrNum[0][0];
        for (int[] ints : arrNum) {
            for (int anInt : ints) {
                if(stadard != anInt){
                    return false;
                }
            }
        }
        return true;
    }
}
