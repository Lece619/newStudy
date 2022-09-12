/*
https://school.programmers.co.kr/learn/courses/30/lessons/12923
        연습문제
        숫자 블록
*/
package normal;

public class NumberBlock {

    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end-begin) + 1];
        int idx = 0;
        for (long i = begin; i <= end; i++) {
            long a = 0;
            if(i == 1){
                idx++;
                continue;
            }
            a = isPrimary(i);
            answer[idx++] = (int) a;
        }
        return answer;
    }

    public long isPrimary(long num){
        long n = (long) Math.sqrt(num);
        long result = 1;
        long returnAnswer = 1;
        for (long i = 2; i < n + 1; i++) {
            if(num % i == 0){
                result = Math.max(i, num/i);
                if(result > 10_000_000){
                    continue;
                }else{
                    returnAnswer = Math.max(result,returnAnswer);
                }
            }
        }
        return returnAnswer;
    }


    public static void main(String[] args) {

        NumberBlock numberBlock = new NumberBlock();
        long begin = 1L;
        long end = 10L;

        int[] answer = numberBlock.solution(begin, end);

        for (int i : answer) {
            System.out.println("i = " + i);
        }

    }
}
