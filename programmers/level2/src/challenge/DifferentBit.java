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
                answer[i] = nextDifferent(numbers[i]);
            }
        }

        return answer;
    }

    public long nextDifferent(long num){
        String binNum = Long.toBinaryString(num);
        StringBuilder sb = new StringBuilder().append(binNum).reverse();
        int firstNum = sb.indexOf("0");
        if(firstNum == -1){
          firstNum = binNum.length();
        }
        double sum = Math.pow(2,firstNum-1);

        return num + (long)sum;
    }


    public static void main(String[] args) {
        long[] solution = new DifferentBit().solution(new long[]{2L, 7L});
        System.out.println("solution[0] = " + solution[0]);
        System.out.println("solution[1] = " + solution[1]);

        System.out.println(new DifferentBit().nextDifferent(7L));
        System.out.println(new DifferentBit().nextDifferent(7L));
    }

}
