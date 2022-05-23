package normal;

import java.util.Arrays;

public class SortString {
    public static void main(String[] args) {
        char a ='a';
        char A = 'A';
        int b =a ;
        System.out.println(b+" "+(int)a+""+(int)A);
    }
class Solution {
    public String solution(String s) {
        String answer = "";
        char[] chars= new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i]=s.charAt(i);
        }
        Arrays.sort(chars);
        return answer;
    }
}
}
