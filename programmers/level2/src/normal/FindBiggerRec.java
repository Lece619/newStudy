// https://programmers.co.kr/learn/courses/30/lessons/12905
// 가장 큰 사각형 찾기
package normal;

import bruteForce.FindPrimary;

import java.util.Random;

//효율성 0;
public class FindBiggerRec {
    public int solution(int [][]board) {
        int answer = 0;
        int total=0;
        for (int[] ints : board) {
            for (int anInt : ints) {
                total+=anInt;
            }
        }
        int num2 = (int)Math.sqrt(total);

        int maxLen  = Math.min(board.length,board[0].length);
        maxLen=Math.min(num2,maxLen);
        for (int i = maxLen; i > 0; i--) {
            //3  3   3
            //x시작 범위 0 ~ x총 길이 -i
            for (int x = 0; x < board.length-i+1; x++) {
            //y시작 범위 0 ~ y총 길이-i
                for (int y = 0; y < board[0].length-i+1; y++) {

                    int size =0;
                    //정사각형 x 부터 x+i까지, y부터 y+1까지
                    boolean flag =true;
                    for (int j = x; j <x+i; j++) {
                        if(!flag) {
                            break;
                        }
                        for (int k = y; k < y+i; k++) {
                            if(board[j][k]==0||!flag){
                                flag=false;
                                break;
                            }
                            size+=board[j][k];
                        }
                    }
                    if(size==i*i){
                        return i*i;
                    }
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
