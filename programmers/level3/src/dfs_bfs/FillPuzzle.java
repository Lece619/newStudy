/*
https://school.programmers.co.kr/learn/courses/30/lessons/84021
        깊이/너비 우선 탐색(DFS/BFS)
        퍼즐 조각 채우기
*/

package dfs_bfs;


import java.util.HashSet;

public class FillPuzzle {

    int idx = 2;
    int[][] blockTable;
    int size;
    int[] x = {0,1,0,-1};
    int[] y = {1,0,-1,0};
    HashSet<Integer> blockSet = new HashSet<>();
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        size = game_board.length;
        blockTable = table.clone();
        int sum = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                sum = makeTable(i,j);
                if(sum!=0) {
                    answer += sum;
                    blockSet.add(idx);
                    idx++;
                }
            }
        }
        //회전 테이블
        int[][] blockTable2 = makeRotation(blockTable);
        int[][] blockTable3 = makeRotation(blockTable2);
        int[][] blockTable4 = makeRotation(blockTable3);

        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board[0].length; j++) {

            }
        }
        for (int[] ints : table) {
            for (int anInt : ints) {
                System.out.print(" " + anInt);
            }
            System.out.println();
        }
        System.out.println();
        for (int[] ints : blockTable2) {
            for (int anInt : ints) {
                System.out.print(" " + anInt);
            }
            System.out.println();
        }
        System.out.println("blockSet = " + blockSet);
        return answer;
    }

    private int[][] makeRotation(int[][] blockTable) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size ; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = blockTable[size- j - 1][i];
            }
        }
        return result;
    }

    private int makeTable(int i, int j) {
        int result = 0;
        if(blockTable[i][j] != 1){
            return 0;
        }else{
            blockTable[i][j] = idx;
            for (int k = 0; k < 4; k++) {
                int changeI = i + x[k];
                int changeJ = j + y[k];
                if(changeI >= 0 && changeI < size &&
                        changeJ >= 0 && changeJ < size){
                    result += makeTable(changeI, changeJ);
                }
            }
            return result + 1;
        }
    }

    /*
    1 0  0 1
    0 0  0 0

    * */
    // 최대 블록 갯수 50 * 50 1250개 4방향 5000번.


    public static void main(String[] args) {
        int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
        int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};

        FillPuzzle fillPuzzle = new FillPuzzle();
        int answer = fillPuzzle.solution(game_board, table);
        System.out.println("answer = " + answer);

    }
}
