/*
https://school.programmers.co.kr/learn/courses/30/lessons/159994
        연습문제
        카드 뭉치
*/

package normal2;


public class CardSets {

    static final String ANSWER_YES = "Yes";
    static final String ANSWER_NO = "No";

    public String solution(String[] cards1, String[] cards2, String[] goal) {

        int card1Index = 0;
        int card2Index = 0;

        for (String word : goal) {

            if(cards1.length > card1Index && cards1[card1Index].equals(word)){
                card1Index++;
                continue;
            }

            if(cards2.length > card2Index && cards2[card2Index].equals(word)){
                card2Index++;
                continue;
            }

            return ANSWER_NO;
        }
        return ANSWER_YES;
    }

    public static void main(String[] args) {
        CardSets cardSets = new CardSets();

        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};


        String solution = cardSets.solution(cards1, cards2, goal);
        System.out.println("solution = " + solution);
    }
}
