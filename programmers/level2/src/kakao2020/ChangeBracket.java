//https://programmers.co.kr/learn/courses/30/lessons/60058
//코딩테스트 연습
//2020 KAKAO BLIND RECRUITMENT
//괄호 변환

package kakao2020;

import java.util.ArrayList;
import java.util.Stack;

public class ChangeBracket {


    public String solution(String p) {
        int count = 0;
        int length = p.length();
        boolean check = true;
        int index = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {

            if(p.charAt(i)=='('){
                count++;
            }else{
                count--;
            }
            if(count<0){
                check = false;
            }
            if(count==0){
                //0을 만났을때 진행
                //index까지 false라면
                if(!check){
                    sb.append('(');
                    sb.append(solution(p.substring(index+1)));
                    sb.append(')');
                    p=step4(p.substring(0,index));
                    sb.append(p);
                }else{  //index까지 true 라면 ok
                    sb.append(p.substring(0,index)).append(solution(p.substring(index)));
                }
                return sb.toString();
            }
        }
        return null;
    }
    //앞뒤 제거후 바꾸기.
    public String step4(String str){
        if(str.length()==2){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length()-1; i++) {
            if (str.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String str = "()))((()";
        System.out.println(new ChangeBracket().step4(str));

    }
}
