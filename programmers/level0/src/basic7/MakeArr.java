package basic7;

import java.util.Arrays;
import java.util.Stack;

public class MakeArr {
    public int[] solution(int[] arr) {
        Stack<Integer> nums = new Stack<>();
        for (int num : arr) {
            makeNums(nums, num);
        }
        return nums.stream().mapToInt(Integer::intValue).toArray();
    }

    private void makeNums(Stack<Integer> nums, int num) {
        if(nums.empty()){
            nums.push(num);
            return;
        }
        if(nums.peek() < num){
            nums.push(num);
            return;
        }
        nums.pop();
        makeNums(nums, num);
    }

    public int[] solution(String[] intStrs, int k, int s, int l) {
        return Arrays.stream(intStrs).mapToInt(str -> Integer.parseInt(str.substring(s, s + l))).filter(num -> num > k).toArray();
    }
}
