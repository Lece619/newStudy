//https://programmers.co.kr/learn/courses/30/lessons/76502
//코딩테스트 연습 -월간 코드 챌린지 시즌2 - 괄호 회전하기
package challenge;

import java.util.Stack;

public class RotationBracket {
        public int solution(String s) {
                int answer = 0;
                for (int i = 0; i < s.length(); i++) {

                        answer += checkBracket(s);

                        s = s.substring(1)+s.charAt(0);
                }
                System.out.println(answer);
                return answer;
        }
        public int checkBracket(String s){

                Stack<Character> stack = new Stack<>();
                for (int i = 0; i < s.length(); i++) {
                        char nowChar = s.charAt(i);
                        if(nowChar == '[' || nowChar == '{'  || nowChar == '(' ){
                                stack.push(nowChar);
                        }else if(nowChar == ']'){
                                if(!stack.isEmpty() && stack.peek() == '['){
                                        stack.pop();
                                }else{
                                        return 0;
                                }
                        }else if(nowChar == '}'){
                                if(!stack.isEmpty() && stack.peek() == '{'){
                                        stack.pop();
                                }else{
                                        return 0;
                                }
                        }else if(nowChar == ')'){
                                if(!stack.isEmpty() && stack.peek() == '('){
                                        stack.pop();
                                }else{
                                        return 0;
                                }
                        }
                }
                return stack.isEmpty() ? 1 : 0;
        }

        public static void main(String[] args) {
                new RotationBracket().solution("}]()[{");
        }
}
