//https://programmers.co.kr/learn/courses/30/lessons/42883


package greedy;

import java.util.Stack;

public class MakeBigNum2 {

    public String solution(String number, int k) {

        Stack<Character> stack = new Stack<>();
        stack.add(number.charAt(0));

        for (int i = 1; i < number.length(); i++) {
            char now = number.charAt(i);
            if(stack.peek() >= now || k==0){

                stack.add(now);
            }else{
                while(!stack.isEmpty() && stack.peek() < now) {
                    stack.pop();
                    k--;
                    if(k==0){
                        break;
                    }
                }

            }
        }
        for (int i = 0; i < k; i++) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        stack.forEach(sb::append);
        return sb.toString();
    }
    public static void main(String[] args) {
        String number = "654321";
        System.out.println(new MakeBigNum2().solution(number,2));

    }

}
