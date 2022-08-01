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
            if(numbers[i] %2 ==0 ){
                answer[i] = numbers[i]+1;
            }else {
                answer[i] = makeDifferent(numbers[i]);
            }
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
        int count = 0 ;
        for (int i = 0; i < xor.length(); i++) {
            if(xor.charAt(i) == '1'){
                count ++ ;
                if(count>2){
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        long[] solution = new DifferentBit().solution(new long[]{2L, 7L});
        System.out.println("solution[0] = " + solution[0]);
        System.out.println("solution[1] = " + solution[1]);
    }

}
