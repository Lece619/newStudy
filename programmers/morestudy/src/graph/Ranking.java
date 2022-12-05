/*
https://school.programmers.co.kr/learn/courses/30/lessons/49191
        그래프
        순위
*/

package graph;

public class Ranking {
    public int solution(int n, int[][] results) {
        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] result = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        Ranking ranking = new Ranking();
        int solution = ranking.solution(n, result);
        System.out.println("solution = " + solution);
    }
}
