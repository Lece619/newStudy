/*
https://school.programmers.co.kr/learn/courses/30/lessons/138477
        연습문제
        명예의 전당 (1)
*/

package normal2;

import java.util.PriorityQueue;

public class HallOfFame {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> scores = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {

            scores.add(score[i]);
            if(scores.size() > k ){
                scores.poll();
            }
            answer[i] = scores.peek();
        }

        return answer;
    }
    public static void main(String[] args) {

        HallOfFame hallOfFame = new HallOfFame();
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        int[] solution = hallOfFame.solution(k, score);

        for (int i : solution) {
            System.out.print(i + "  ");
        }

    }
}
