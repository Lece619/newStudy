/*
https://school.programmers.co.kr/learn/courses/30/lessons/12909
        스택/큐
        올바른 괄호
*/

package stackqueue;

import java.util.Stack;

public class RightBracket {

    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> chars = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            answer = checkChars(chars, s.charAt(i));
            if(!answer){
                break;
            }
        }

        return answer && chars.isEmpty();
    }

    private boolean checkChars(Stack<Character> chars, char nowChar) {
        if(nowChar == '(')
            return chars.add(nowChar);
        if(chars.isEmpty())
            return false;
        if(chars.peek() == '('){
            chars.pop();
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new RightBracket().solution("(())()");
    }
}
