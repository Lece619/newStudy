package callengeSeason;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class SumChooseTwo {
    public static void main(String[] args) {
        new SumChooseTwo().new Solution().solution(new int[]{1,2,3,4,5,6,7});
    }

class Solution {
    public Integer[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                set.add(numbers[i]+numbers[j]);
            }
        }
        ArrayList<Integer> list = new ArrayList(set);
        Collections.sort(list);
        System.out.println(list);
        int size= list.size();
        Integer[] answer = list.toArray(new Integer[list.size()]);
        return answer;
    }
}
}