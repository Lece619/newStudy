/*
https://school.programmers.co.kr/learn/courses/30/lessons/84021
        깊이/너비 우선 탐색(DFS/BFS)
        퍼즐 조각 채우기
*/

package dfs_bfs;

public class FillPuzzle {
    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;
        return answer;
    }

    public static void main(String[] args) {
        int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
        int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};

        FillPuzzle fillPuzzle = new FillPuzzle();
        int answer = fillPuzzle.solution(game_board, table);

    }
}
