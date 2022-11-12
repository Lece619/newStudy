/*
https://school.programmers.co.kr/learn/courses/30/lessons/135807
        연습문제
        숫자 카드 나누기
*/

package normal2;

public class SplitNumberCard {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcbA = arrayA[0];
        int gcbB = arrayB[0];

        for (int i = 1; i < arrayA.length; i++) {
            gcbA = gcb(gcbA, arrayA[i]);
        }

        for (int i = 1; i < arrayB.length; i++) {
            gcbB = gcb(gcbB, arrayB[i]);
        }

        return Math.max(findMaxNumber(gcbA, arrayB), findMaxNumber(gcbB, arrayA));
    }

    private int findMaxNumber(int gcb, int[] array) {

        int result = 0;

        for (int i = 1; i <= gcb; i++) {
            if(gcb % i == 0 && checkRemain(i, array)){
                result = i;
            }
        }

        return result;
    }

    private boolean checkRemain(int num, int[] array) {
        for (int i : array) {
            if(i % num == 0){
                return false;
            }
        }
        return true;
    }

    public int gcb(int a, int b){
        if(b==0){
            return a;
        }
        return gcb(b, a % b);
    }

    public static void main(String[] args) {
        int[] arrayA = {14, 35, 119};
        int[] arrayB = {18, 30, 102};
        SplitNumberCard splitNumberCard = new SplitNumberCard();
        int solution = splitNumberCard.solution(arrayA, arrayB);
        System.out.println("solution = " + solution);
    }
}
