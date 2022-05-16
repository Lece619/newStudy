package monthSeason;

public class TrueFalseSum {

    class Solution {
        public int solution(int[] absolutes, boolean[] signs) {
            int answer=0;
            int plusMinus=1;
            for (int i = 0; i < absolutes.length; i++) {
                plusMinus = signs[i] ? 1 : -1 ;
                answer += absolutes[i] * plusMinus;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
