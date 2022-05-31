//https://programmers.co.kr/learn/courses/30/lessons/12973
//프로그래머스 - 짝지어 제거하기

package tipstown2017;

import java.util.Stack;

//괄호문제랑 같지않나?
public class RemoveCouple {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(c);
            }else{
                if(stack.peek()==c){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;

    }



    public static void main(String[] args) {
    }
}
