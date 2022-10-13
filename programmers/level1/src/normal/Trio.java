/*
https://school.programmers.co.kr/learn/courses/30/lessons/131705
        연습문제
        삼총사 
*/
package normal;

public class Trio {

    public int solution(int[] number) {
        int answer = 0;
        for (int i = 0; i < number.length; i++) {
            for (int j = i+1; j < number.length; j++) {
                for (int k = j+1; k < number.length; k++) {
                    if(number[i] + number[j] + number[k]==0){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Trio trio = new Trio();
        int[] number = {-2, 3, 0, 2, -5};
        int solution = trio.solution(number);
        System.out.println("solution = " + solution);
    }
}
