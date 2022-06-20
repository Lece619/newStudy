//https://programmers.co.kr/learn/courses/30/lessons/42842

//코딩테스트 연습완전탐색 카펫
package normal;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        long max = (long)brown + (long)yellow;
        int maxRow = (brown-2) / 2;
        int[] answer = new int[2];
        for (int i = maxRow; i >= (double)((brown+4)/4); i--) {
            long column = brown / 2 - i + 2;
            if ((i - 2) * (column - 2) == yellow) {
                answer[0] = (int)i;
                answer[1] = (int)column;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        new Carpet().solution(10,2);
    }
}
