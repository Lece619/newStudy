//https://programmers.co.kr/learn/courses/30/lessons/12909 올바른 괄호
package normal;

import java.util.Stack;

public class RightBracket {

        boolean solution(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c=='('){
                    stack.push(c);
                }else{
                    if(stack.isEmpty()){
                        return false;
                    }else{
                        stack.pop();
                    }
                }
            }
            return stack.isEmpty() ? true : false;
        }

}
