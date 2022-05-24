package normal;

import java.util.Arrays;
import java.util.Collections;

public class MakeStrange {
    public static void main(String[] args) {
        new MakeStrange().solution("try hello world ZZZZZZzZaaasdasaaaaaaaaa");
    }
    public String solution(String s) {
        String temp = s.replaceAll(" ","*");
        String answer="";
        boolean check =true;
        for (int i = 0; i < temp.length(); i++) {
             if(temp.charAt(i)=='*'){
                 answer+=" ";
                 check = true;
             }else {
                 if (check) {
                     answer += Character.toUpperCase(temp.charAt(i));
                 } else {
                     answer += Character.toLowerCase(temp.charAt(i));
                 }
                 check = !check;
             }
             Arrays.sort(new String[]{"12"}, Collections.reverseOrder());
        }
        return answer;
    }
}
