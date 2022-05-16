/*
* https://programmers.co.kr/learn/courses/30/lessons/64061?language=java
*/

package kakao2019;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ClawCrane {
    public static void main(String[] args) {
        int[][] board ={{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        Solution a = new Solution();
        System.out.println(a.solution(board,moves));
    }

    static class Solution {
        public int solution(int[][] board, int[] moves) {
            int size = board[0].length;
            ArrayList<Queue<Integer>> dolls= new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            int answer = 0;
            //queue 생성
            for (int i = 0; i < size; i++) {
                dolls.add(new LinkedList<>());
            }
            for(int i=0;i<size;i++){
                for(int j = 0; j < size; j++){
                    if(board[i][j]!=0) {
                        dolls.get(j).add(board[i][j]);
                    }
                }
            }
           /* for (Queue<Integer> doll : dolls) {
                System.out.println(doll);
            }*/

            for(int move : moves){

                if(!dolls.get(move-1).isEmpty()){
                    //움직일 자리의 인형이 있고 , 스택이 비어있을 때
                    int moveDoll=dolls.get(move-1).poll();
                    if(stack.isEmpty()){
                        stack.add(moveDoll);
                    }else if(stack.peek()==moveDoll){
                        //스택이 비어 있지 않을 때 , 스택의 최고와 제거된 인형이 같으면 스택에서 빼준다.
                        stack.pop();
                        answer+=2;
                    }else{
                        //스택이 비어있지 않고, 스택 최고와 다를때
                        stack.add(moveDoll);
                    }
                }
            }

            return answer;
        }
    }
}
