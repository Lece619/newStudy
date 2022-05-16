package season3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class NoNumSum {
    public static void main(String[] args) {
        Solution a = new Solution();
        System.out.println(a.solution(new int[]{1,2,3,4,6,7,8,0}));
    }
    static class Solution {
        public int solution(int[] numbers) {
            Set<Integer> set = new HashSet<Integer>();
            for (int number : numbers) {
                set.add(number);
            }
            int answer = 0;
            for(int num = 0 ;num<10;num++){
                if(!set.contains(num)){
                    answer+=num;
                }
            }
            return answer;
        }
    }
}
