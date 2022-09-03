/*
https://school.programmers.co.kr/learn/courses/30/lessons/87390
        코딩테스트 연습
        월간 코드 챌린지 시즌3
        n^2 배열 자르기
*/
package challenge;

public class CutArray {

    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        long index = 0L;
        int idx = 0;
        long startI = left / n;
        index += n * startI;
        for (int i = (int) startI; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(index >= left && index <= right){
                    answer[idx++] = Math.max(i, j) + 1;
                }
                if(index == right) {
                    return answer;
                }
                index++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        CutArray test = new CutArray();
        int[] solution = test.solution(3, 2L, 5L);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
