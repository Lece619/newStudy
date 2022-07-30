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
        int answer = 0;
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
            //1 로테이션
            flag = false;
            for (int i = 0; i < blocks.length-1; i++) {
                for (int j = 0; j < blocks[0].size()-1; j++) {
                    if(blocks[i].get(j)=='0'){
                        break;
                    }
                    checkBlock(i, j);
                }
            }

            for (int i = 0; i < blocks.length; i++) {
                for (int j = 0; j < blocks[0].size(); j++) {
                    if(blocks[i].get(j)=='0'){
                        break;
                    }
                    if(check[i][j]){
                        check[i][j] = false;
                        blocks[i].set(j, '1');
                        blocks[i].add('0');
                        answer++;
                    }
                }
                while(blocks[i].contains('1')){
                    Character a = '1';
                    blocks[i].remove(a);
                }
            }
<<<<<<< HEAD
            
=======
            System.out.println("blocks = " + blocks[0]);
            System.out.println("blocks = " + blocks[1]);
            System.out.println("blocks = " + blocks[2]);
            System.out.println("blocks = " + blocks[3]);
            System.out.println("blocks = " + blocks[4]);
            System.out.println("blocks = " + blocks[5]);
            System.out.println(
                    "\n"
            );
>>>>>>> parent of 501da5e (Update FriendsFourBlock.java)
        }

        System.out.println("blocks = " + blocks[0]);
        System.out.println("blocks = " + blocks[1]);
        System.out.println("blocks = " + blocks[2]);
        System.out.println("blocks = " + blocks[3]);
        System.out.println("blocks = " + blocks[4]);
        System.out.println("blocks = " + blocks[5]);


        System.out.println("answer = " + answer);
        return answer;
    }

    public void checkBlock(int x, int y){
        Character c = blocks[x].get(y);
        boolean same = c == blocks[x].get(y+1) && c == blocks[x+1].get(y) && c == blocks[x+1].get(y+1);
        if(same){
            check[x][y] = true;
            check[x+1][y] = true;
            check[x+1][y+1] = true;
            check[x][y+1] = true;
            flag = same;
        }
    }

    public static void main(String[] args) {
        FriendsFourBlock test = new FriendsFourBlock();
        int m = 6;
        int n = 6;

        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        test.solution(m, n, board);

    }
}
