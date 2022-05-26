package kakao2020;

import java.util.LinkedList;
import java.util.Queue;

public class StringCompression2 {
    public int solution(String s) {

        if(s.length()==0) return 1;
        //7 글자 짜리 3
        //0 3 3 - 6 6~
        int answer = 0;
        int len = s.length()/2;
        int limit = s.length()-len-s.length()%len;
        for (int k = 1; k <= len; k++) {

            Queue<String> queue = new LinkedList<>();
            for (int i = 0; i < s.length(); i += k) {


                System.out.println(i + "  " + limit);

                if (i + k > s.length()) {
                    System.out.println(s.substring(i));
                } else {
                    System.out.println(s.substring(i, i + k));
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        new StringCompression2().solution("abcdefghi");
    }
}
