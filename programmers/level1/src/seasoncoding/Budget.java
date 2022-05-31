package seasoncoding;

import java.util.Arrays;

public class Budget {
    public static void main(String[] args) {

    }
    class Solution {
        public int solution(int[] d, int budget) {
            int answer = 0;
            Arrays.sort(d);
            for (int i : d) {
                System.out.println(i);
                if(budget >= i){
                    budget-=i;
                    answer++;
                }
            }
            return answer;
        }
    }
}
