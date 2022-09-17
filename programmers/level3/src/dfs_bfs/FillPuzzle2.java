/*
https://school.programmers.co.kr/learn/courses/30/lessons/84021
        깊이/너비 우선 탐색(DFS/BFS)
        퍼즐 조각 채우기
*/

package dfs_bfs;


import java.util.HashMap;
import java.util.HashSet;

public class FillPuzzle2 {

    int idx = 2;
    int[][] blockTable;
    int size;
    int[] x = {1,0,-1,0};
    int[] y = {0,-1,0,1};
    int tableNum = 1;
    HashSet<Integer> blockSet = new HashSet<>();
    HashMap<Integer, String> answerMap = new HashMap<>();
    HashMap<Integer, Integer> blockSize = new HashMap<>();
    StringBuilder sb;

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        size = game_board.length;
        blockTable = game_board.clone();
        int sum = 0;
        //블록 인덱스
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb = new StringBuilder();
                sum = makeTable(i,j,5);
                if(sum!=0) {
                    blockSet.add(idx);
                    answerMap.put(idx, sb.toString());
                    blockSize.put(idx,sum);
                    idx++;
                }
            }
        }
        System.out.println("answerMap = " + answerMap);
        System.out.println("blockSize = " + blockSize);

        //회전 테이블

        int[][] blockTable1 = table.clone();
        printarrays(blockTable1);
        answer = getAnswer(blockTable1, answer);
        tableNum++;
        int[][] blockTable2 = makeRotation(blockTable1);
        answer = getAnswer(blockTable2, answer);
        tableNum++;
        int[][] blockTable3 = makeRotation(blockTable2);
        answer = getAnswer(blockTable3, answer);
        tableNum++;
        int[][] blockTable4 = makeRotation(blockTable3);
        answer = getAnswer(blockTable4, answer);

        printarrays(blockTable);
        printarrays(blockTable2);
        printarrays(blockTable3);
        printarrays(blockTable4);

        return answer;
    }

    private void printarrays(int[][] blockTable1) {
        for (int[] ints : blockTable1) {
            for (int anInt : ints) {
                System.out.print( anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private int getAnswer(int[][] getTable, int answer) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb = new StringBuilder();
                hasBlock(i, j, getTable,5, tableNum, tableNum+1);
                if(sb.length()!=0){
                    System.out.println("sb.toString() = " + sb.toString());
                    for (Integer integer : answerMap.keySet()) {
                        if(answerMap.get(integer).equals(sb.toString())){
                            answerMap.remove(integer);
                            answer += blockSize.get(integer);
                            hasBlock(i, j, getTable,5, tableNum+1, 0);
                            break;
                         }
                    }
                }
            }
        }
        return answer;
    }

    private void hasBlock(int i, int j, int[][] checkTable, int numIdx, int targetNum, int changeNum) {
        if(checkTable[i][j] != targetNum){
            return;
        }else{
            checkTable[i][j] = changeNum;
            sb.append(numIdx);
            for (int k = 0; k < 4; k++) {
                sb.append(0);
                int changeI = i + x[k];
                int changeJ = j + y[k];
                if(changeI >= 0 && changeI < size &&
                        changeJ >= 0 && changeJ < size){
                    hasBlock(changeI, changeJ, checkTable, k, targetNum, changeNum);
                }
            }
        }
    }

    private int makeTable(int i, int j, int numIdx) {
        int result = 0;
        if(blockTable[i][j] != 0){
            return 0;
        }else{
            blockTable[i][j] = idx;
            sb.append(numIdx);
            for (int k = 0; k < 4; k++) {
                sb.append(0);
                int changeI = i + x[k];
                int changeJ = j + y[k];
                if(changeI >= 0 && changeI < size &&
                        changeJ >= 0 && changeJ < size){
                    result += makeTable(changeI, changeJ, k);
                }
            }
            return result + 1;
        }
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

    /*
    1 0  0 1
    0 0  0 0

    * */
    // 최대 블록 갯수 50 * 50 1250개 4방향 5000번.


    public static void main(String[] args) {
//        int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
//        int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};
        int[][] game_board = {{0, 0, 0}, {1, 1, 0}, {1, 1, 1}};
        int[][] table = {{1, 1, 1}, {1, 0, 0}, {0, 0, 0}};

        FillPuzzle2 fillPuzzle = new FillPuzzle2();
        int answer = fillPuzzle.solution(game_board, table);
        System.out.println("answer = " + answer);

    }
}
