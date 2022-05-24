package normal;

import java.util.Arrays;
import java.util.Collections;

public class SortString {
    public static void main(String[] args) {
        char a ='a';
        char A = 'A';
        int b =a ;
        System.out.println(b+" "+(int)a+""+(int)A);
        new SortString().new Solution().solution("Zbcdefg");
    }
class Solution {
    public String solution(String s) {
        String answer = "";
        char[] chars= new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i]=s.charAt(i);
            System.out.println(chars[i]);
        }
        Arrays.sort(chars);
        //System.out.println(chars);
        for (int i = chars.length-1; i >= 0; i--) {
            answer+=chars[i];
        }
        System.out.println("answer  "+answer);
        return answer;
    }
}
/*
*    public String reverseStr(String str){
        return Stream.of(str.split(""))
    .sorted(Comparator.reverseOrder())
    .collect(Collectors.joining());
    }
* */
}
