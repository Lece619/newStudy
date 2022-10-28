package helponboard;

import java.util.Stack;

public class StringStack {
    public static String solution(String word){

        Stack<Character> stack = new Stack<>();

        boolean isContinue = false;

        for (int i = 0; i < word.length(); i++) {

            if( isContinue ){
                stack.pop();
                isContinue = false;
            }

            if(stack.isEmpty()){
                stack.add(word.charAt(i));
            }else{

                while(i < word.length() && stack.peek() == word.charAt(i)){
                    i++;
                    isContinue = true;
                }

                if( !isContinue ){
                    stack.add(word.charAt(i));
                    isContinue = false;
                }
            }
        }

        Stack<Character> stack2 = new Stack<>();

        char peek = ' ';

        for (char c : word.toCharArray()) {

            if(!stack2.isEmpty() &&  stack2.peek() == c){
                stack2.pop();
                peek = c;
            }else if(peek != c){
                stack.add(c);
                peek = ' ';
            }

        }

        return stack.toString();
    }

    public static void main(String[] args) {
        String solution = StringStack.solution("brooornddernn");
        System.out.println("brooornddernn = " + solution);
    }
}
