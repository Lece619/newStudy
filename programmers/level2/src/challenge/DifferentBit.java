/*
https://school.programmers.co.kr/learn/courses/30/lessons/77885
        logo
        코딩테스트 연습
        월간 코드 챌린지 시즌2
        2개 이하로 다른 비트
*/
package challenge;

public class DifferentBit {



    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            answer[i] = makeDifferent(numbers[i]);
        }

        return answer;
    }

    public long makeDifferent(long num1){
        boolean check = true;
        long num2 = num1;
        while(check){
            num2++;
            check = checkDifferentNum(num1, num2);
        }
        return num2;
    }

    boolean checkDifferentNum(long num1, long num2){
        String xor = Long.toBinaryString(num1 ^ num2);
        int count = xor.replace("0", "").length();
        return count > 2;
    }


    public static void main(String[] args) {
       //new DifferentBit().solution(new long[]{2L,7L});
        long num1 = 7L;
        long num2 = 11L;
        System.out.println(Long.toBinaryString(num1 ^ num2));
    }

}
