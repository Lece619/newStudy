//https://programmers.co.kr/learn/courses/30/lessons/42746
//코딩테스트 연습 - 정렬 가장 큰 수
package normal;

import java.util.Arrays;
import java.util.Comparator;

public class BiggerNum {

        public String solution(int[] numbers) {
                StringBuilder sb = new StringBuilder();
                String[] number = new String[numbers.length];
                for (int i = 0; i < number.length; i++) {
                        number[i]= numbers[i]+"";
                }
                Arrays.sort(number, new Comparator<String>() {
                        @Override
                        public int compare(String o1, String o2) {

                                return (o2+o1).compareTo(o1+o2);
                        }
                });
                if(number[0].equals("0")){
                        return "0";
                }
                String answer = "";
                for (String s : number) {
                        answer+=s;
                }
                System.out.println(answer);
                return answer;
        }


        public static void main(String[] args) {
                int[] number = {102, 10, 101, 10, 1, 99, 9, 999};
                //99999911021011010
                //99999911021010101
                boolean[] num = new boolean[100_000];
                /*Arrays.sort(number, new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                                int num1 = upNum(o1);
                                int num2 = upNum(o2);
                                System.out.println(o1+"  "+o2);
                                System.out.println(num1+"  "+num2);
                                return num2-num1;
                        }
                        987654321101000
                        987654321101000
                });*/
                //  13  131
                //   51  555  512
                //  62  66  67
                //  626 627
                //1000=>10000

               new BiggerNum().solution(number);
        }
}
