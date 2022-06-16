//https://www.acmicpc.net/problem/12015
//백준알고리즘 - 가장 긴 증가 부분수열

import java.util.Scanner;

public class Num12015 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        int[] len = new int[N];
        int longer = 1;
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        len[0]=nums[0];

        for (int i = 1; i < N; i++) {
            int next = nums[i];
            if(len[longer-1] < next){
                len[longer] = next;
                longer++;
            }else{
                //이분탐색으로 제일 가까운 수를 찾아줘서 변환한다.
                int min = 0;
                int max = longer;
                while(min<max){
                    int mid = ( min + max ) / 2;

                    if(len[mid] < next){
                        min = mid + 1;
                    }else{
                        max = mid;
                    }
                }
                len[min] = next;
            }
        }
        System.out.println(longer);
    }
}
