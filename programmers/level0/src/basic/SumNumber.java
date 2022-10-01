/*
https://school.programmers.co.kr/learn/courses/30/lessons/120923
        코딩테스트 입문
        연속된 수의 합
*/

        package basic;

public class SumNumber {
        public int[] solution(int num, int total) {
                int[] answer = new int[num];
                int check = num*(num+1) / 2;
                int start = (total - check) / num + 1;
                for (int i = 0; i < answer.length; i++) {
                        answer[i] = start + i ;
                }
                return answer;
        }
        public static void main(String[] args) {
                int num = 3;
                int total = 12;
                SumNumber sumNumber = new SumNumber();
                int[] solution = sumNumber.solution(num, total);
                System.out.println("solution = " + solution);
        }
}
