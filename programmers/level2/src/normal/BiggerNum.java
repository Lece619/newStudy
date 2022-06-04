//https://programmers.co.kr/learn/courses/30/lessons/42746
//코딩테스트 연습 - 정렬 가장 큰 수
package normal;

import java.util.*;

public class BiggerNum {
        boolean[] check;
        int[] number;
        long max;
        StringBuilder sb;

        public String solution(int[] numbers) {
                check=new boolean[numbers.length];
                sb = new StringBuilder();
                max = 0;
                number=numbers;
                makeList(0,numbers.length);
                System.out.println(max);
                return max+"";
        }
        public void makeList(int n,int length){
                if(n==length){
                        if(max < Long.parseLong(sb.toString())){
                                max=Long.parseLong(sb.toString());
                        }
                }else{
                        for (int i = 0; i < length; i++) {
                                if(!check[i]){
                                    check[i]=true;
                                    StringBuilder sbTemp = new StringBuilder(sb);
                                    sb.append(number[i]);
                                    makeList(n+1,length);
                                    sb=sbTemp;
                                    check[i]=false;
                                }
                        }
                }
        }

        public static void main(String[] args) {
                int[] number = {3, 30, 34, 5, 9};
                boolean[] num = new boolean[100_000];

               new BiggerNum().solution(number);
        }
}
