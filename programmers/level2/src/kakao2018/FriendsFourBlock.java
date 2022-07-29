/*
https://school.programmers.co.kr/learn/courses/30/lessons/17679
        코딩테스트 연습
        2018 KAKAO BLIND RECRUITMENT
        [1차] 프렌즈4블록
*/
package kakao2018;

import java.util.ArrayList;
import java.util.Arrays;

public class FriendsFourBlock {
    ArrayList<Character>[] blocks;
    boolean[][] check;
    boolean flag;

    public int solution(int m, int n, String[] board) {
        blocks = new ArrayList[board[0].length()];
        check = new boolean[board[0].length()][board.length];
        // 초기화
        for (int i = 0; i < blocks.length; i++) {
            blocks[i] = new ArrayList<>();
        }
        //역순으로 읽어들인다.
        for (int i = board.length-1; i >= 0; i--) {
            String str = board[i];
            for (int j = 0; j < str.length(); j++) {
                blocks[j].add(str.charAt(j));
            }
        }

        flag = true;
        while(flag){
            for (int i = 0; i < blocks.length-1; i++) {
                for (int j = 0; j < blocks[0].size()-1; j++) {
                    if(blocks[i].get(j)=='0'){
                        break;
                    }
                    checkBlock(i, j);
                }
            }
        }

/*        System.out.println("blocks = " + blocks[0]);
        System.out.println("blocks = " + blocks[1]);
        System.out.println("blocks = " + blocks[2]);
        System.out.println("blocks = " + blocks[3]);
        System.out.println("blocks = " + blocks[4]);*/


        int answer = 0;
        return answer;
    }

    public void checkBlock(int x, int y){

    }

    public static void main(String[] args) {
        FriendsFourBlock test = new FriendsFourBlock();
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        test.solution(m, n, board);

    }
}
