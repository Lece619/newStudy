package inner;

import java.util.Scanner;
import java.util.Stack;

public class test3 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String answer = "true";
        String s=in.nextLine();
        //여기에 코드를 써주세요.
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ')'){
                if(stack.isEmpty()){
                    answer = "false";
                    break;
                }
                stack.pop();
            }else{
                stack.add(c);
            }
        }
        if(!stack.isEmpty()){
            answer = "false";
        }
        System.out.println(answer);
    }
}
