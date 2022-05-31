package maester;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

import static java.util.Arrays.*;

public class Phoneketmon {
    public static void main(String[] args) {
    }
    class Solution {
        public int solution(int[] nums) {
            HashSet<Integer> mon = new HashSet<>();
            int answer = nums.length/2;
            IntStream.range(0,nums.length).forEach(i->mon.add(nums[i]));
            System.out.println(mon);
            if(answer<mon.size()){
                return answer;
            }else{
                return mon.size();
            }
        }
    }
}
