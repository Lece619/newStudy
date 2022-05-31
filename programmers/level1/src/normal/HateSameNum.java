package normal;

import java.util.Stack;

public class HateSameNum {
    public static void main(String[] args) {

    }
public class Solution {
    public Integer[] solution(int []arr) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        stack.add(arr[0]);
        for (int i : arr) {
            if(stack.peek()!=i){
                stack.add(i);
            }
        }
        Integer[] as = stack.toArray(new Integer[0]);
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return as;
    }
}
}
