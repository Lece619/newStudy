/*
https://school.programmers.co.kr/learn/courses/30/lessons/131130
        연습문제
        혼자 놀기의 달인
*/

package normal;

public class PlayOwn {
    public int solution(int[] cards) {
        int result = 0;
        int[] box = new int[cards.length];
        for (int i = 0; i < box.length-1; i++) {
            for (int j = i+1; j < box.length; j++) {
                boolean[] check = new boolean[cards.length];
                box[i] = 0;
                box[j] = 0;
                if(!check[i]){
                    box[i] = findNum(i, cards, check);
                }
                if(!check[j]){
                    box[j] = findNum(j, cards, check);
                }
                result = Math.max(result, box[i] * box[j]);
            }
        }
        return result;
    }

    private int findNum(int i, int[] cards, boolean[] check) {
        int result = 1;
        check[i] = true;
        int nextIdx = cards[i]-1;
        while(!check[nextIdx]){
            check[nextIdx] = true;
            result++;
            nextIdx = cards[nextIdx] - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        PlayOwn playOwn = new PlayOwn();
        int[] cards = {8,6,3,7,2,5,1,4};
        int solution = playOwn.solution(cards);
        System.out.println("solution = " + solution);
    }
}
